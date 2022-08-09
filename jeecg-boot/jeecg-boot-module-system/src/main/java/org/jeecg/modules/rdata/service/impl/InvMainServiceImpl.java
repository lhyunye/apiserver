package org.jeecg.modules.rdata.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.elasticsearch.common.Strings;
import org.elasticsearch.index.query.*;
import org.jeecg.modules.rdata.entity.InvCom;
import org.jeecg.modules.rdata.entity.InvMain;
import org.jeecg.modules.rdata.mapper.InvMainMapper;
import org.jeecg.modules.rdata.service.IInvMainService;
import org.jeecg.modules.rdata.util.ElasticsearchUtil;
import org.jeecg.modules.rdata.util.PubUtil;
import org.jeecg.modules.rdata.vo.CheckResurt;
import org.jeecg.modules.rdata.vo.EsCheckResurt;
import org.jeecg.modules.rdata.vo.QueryInvMain;
import org.jeecg.modules.rdata.vo.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.util.ObjectUtils;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: 小票主单表
 * @Author: jeecg-boot
 * @Date:   2021-04-23
 * @Version: V1.0
 */
@DS("multi-datasource1")
@Service
public class InvMainServiceImpl extends ServiceImpl<InvMainMapper, InvMain> implements IInvMainService {

    @Autowired
    private InvComServiceImpl invComService;


    @Override
    public CheckResurt checkAndput(QueryWrapper<InvMain> queryWrapper, QueryInvMain queryInvMain, String copt) {
        String resultMessage="查询参数正常";
        CheckResurt checkResurt = new CheckResurt();
        checkResurt.setResultMessage(resultMessage);
        //校验门店
        if(Strings.isEmpty(queryInvMain.getStoreCode())){
            resultMessage="请选择门店";
            checkResurt.setResultMessage(resultMessage);
            return checkResurt;
        }
        //校验时间格式
        if(!Util.checkTimeFormat(queryInvMain.getRqsjStart())||!Util.checkTimeFormat(queryInvMain.getRqsjEnd())){
            resultMessage="交易日期时间格式错误";
            checkResurt.setResultMessage(resultMessage);
            return checkResurt;
        }

        //检验是否含有商品编码  -- 有则查询小票明细
        String com_code = queryInvMain.getComCode();
        if(!Strings.isEmpty(com_code)){
            //查询拥有该商品编码的小票号
            List<String> seqnos = invComService.listObjs(new QueryWrapper<InvCom>().select("seqno").eq("copt", copt)
                    .like("com_code", com_code).orderByDesc("rqsj"), Object::toString);
            if (ObjectUtils.isEmpty(seqnos)){
                resultMessage="商品编码查询不存在";
                checkResurt.setResultMessage(resultMessage);
                return checkResurt;
            }
            queryWrapper.in("seqno",seqnos);
        }
        //校验交易类别   可多选
        String djlb = queryInvMain.getDjlb();
        if (!Strings.isEmpty(djlb)){
            if (djlb.contains(",")){
                queryWrapper.in("djlb",djlb.split(","));
            }else {
                queryWrapper.eq("djlb",djlb);
            }
        }
        //拼接查询条件
        queryWrapper.eq("copt",copt)
                .eq(!Strings.isEmpty(queryInvMain.getSyjh()),"syjh",queryInvMain.getSyjh())
                .eq(!Strings.isEmpty(queryInvMain.getSyyh()),"syyh",queryInvMain.getSyyh())
                .like(!Strings.isEmpty(queryInvMain.getSeqno()),"seqno",queryInvMain.getSeqno())
                .like(!Strings.isEmpty(queryInvMain.getHykh()),"hykh",queryInvMain.getHykh())
                .ge(!Strings.isEmpty(queryInvMain.getRqsjStart()),"dhrq",queryInvMain.getRqsjStart())
                .le(!Strings.isEmpty(queryInvMain.getRqsjEnd()),"dhrq",queryInvMain.getRqsjEnd())
                .orderByDesc("rqsj");
        checkResurt.setQueryWrapper(queryWrapper);
        return checkResurt;
    }

    @Override
    public EsCheckResurt checkAndput(BoolQueryBuilder query, QueryInvMain queryInvMain) {
        String resultMessage="查询参数正常";
        EsCheckResurt checkResurt = new EsCheckResurt();

        //校验时间格式
        if(!Util.checkTimeFormat(queryInvMain.getRqsjStart())||!Util.checkTimeFormat(queryInvMain.getRqsjEnd())){
            resultMessage="交易日期时间格式错误";
            checkResurt.setResultMessage(resultMessage);
            checkResurt.setQuery(null);
            return checkResurt;
        }
        BoolQueryBuilder comquery = QueryBuilders.boolQuery();
        //拼接查询条件
//        MatchPhraseQueryBuilder dsquery = QueryBuilders.matchPhraseQuery("ds", ds);
//        query.must(dsquery);
        //拼接门店编码 可多选
        String storeCode = queryInvMain.getStoreCode();
        if(!Strings.isEmpty(storeCode)){
            if(storeCode.contains(",")){
                String[] split = storeCode.split(",");
                List<String> stores = Arrays.asList(split);
                TermsQueryBuilder storeCodesquery = QueryBuilders.termsQuery("store_code",stores);
                query.must(storeCodesquery);
                comquery.must(storeCodesquery);
            }else {
                if (!"allStore".equals(storeCode)){
                    MatchPhraseQueryBuilder storeCodesquery = QueryBuilders.matchPhraseQuery("store_code", storeCode);
                    query.must(storeCodesquery);
                    comquery.must(storeCodesquery);
                }

            }

        }
        //忽略逻辑删除位  1：有效数据  0 逻辑删除数据
        MatchPhraseQueryBuilder operationType = QueryBuilders.matchPhraseQuery("operation_type", "1");
        query.must(operationType);

        //商品编码
        if(!Strings.isEmpty(queryInvMain.getComCode())){

            WildcardQueryBuilder comCodeQuery = QueryBuilders.wildcardQuery("com_code", "*"+queryInvMain.getComCode()+"*");
            comquery.must(comCodeQuery);
            comquery.must(operationType);
            List<String> seqnoList= ElasticsearchUtil.searchDataPageByFold("es_inv_com_dd", "first", 0, 0, comquery, "seqno", "rqsj", "","seqno");
            TermsQueryBuilder seqnoTerm = QueryBuilders.termsQuery("seqno", seqnoList);
            query.must(seqnoTerm);

        }

        //校验交易类别   1:正常  2：退货
        String djlb = queryInvMain.getDjlb();
        if (!Strings.isEmpty(djlb)){
            if ("1".equals(djlb)){
                //正常：包含正常(djlb=1)和集团销售(djlb=6)
                TermsQueryBuilder djlbQuery = QueryBuilders.termsQuery("djlb","1","6");
                query.must(djlbQuery);
            }else if ("2".equals(djlb)){
                //退货：包含退货(djlb=2)和集团退货(djlb=7)
                TermsQueryBuilder djlbQuery = QueryBuilders.termsQuery("djlb","2","7");
                query.must(djlbQuery);
            }else {
                resultMessage="交易类别数值错误1:正常  2：退货";
                checkResurt.setResultMessage(resultMessage);
                checkResurt.setQuery(null);
                return checkResurt;
            }

        }
        JSONObject invMain = (JSONObject)JSONObject.toJSON(queryInvMain);
//        //精确查询
//        String[] fields = {"syjh","syyh"};
//
//        for (String field : fields) {
//            if(!ObjectUtils.isEmpty(invMain.getOrDefault(field,""))){
//                MatchPhraseQueryBuilder storequery = QueryBuilders.matchPhraseQuery(field, invMain.getOrDefault(field,"").toString());
//                query.must(storequery);
//            }
//        }
        //模糊查询
        String[] dimFields = {"seqno","hykh","syjh","syyh"};
        for (String field : dimFields) {
            if(!ObjectUtils.isEmpty(invMain.getOrDefault(field,""))){
                WildcardQueryBuilder storequery = QueryBuilders.wildcardQuery(field, "*"+invMain.getOrDefault(field,"")+"*");
                query.must(storequery);
            }
        }

        // 设置时间范围
        if (!Strings.isEmpty(queryInvMain.getRqsjStart()))
            query.filter(QueryBuilders.rangeQuery("rqsj").gte(queryInvMain.getRqsjStart()));
        if (!Strings.isEmpty(queryInvMain.getRqsjEnd()))
            query.filter(QueryBuilders.rangeQuery("rqsj").lte(LocalDate.parse(queryInvMain.getRqsjEnd()).plusDays(1).format(PubUtil.df)));
        // 设置金额区间
        if (!Strings.isEmpty(queryInvMain.getJeStart()))
            query.filter(QueryBuilders.rangeQuery("ysje").gte(queryInvMain.getJeStart()));
        if (!Strings.isEmpty(queryInvMain.getJeEnd()))
            query.filter(QueryBuilders.rangeQuery("ysje").lte(queryInvMain.getJeEnd()));


        checkResurt.setQuery(query);
        return checkResurt;
    }


}
