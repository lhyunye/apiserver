package org.jeecg.modules.rdata.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.elasticsearch.common.Strings;
import org.elasticsearch.index.query.*;
import org.jeecg.modules.rdata.entity.StrRkDoc;
import org.jeecg.modules.rdata.mapper.StrRkDocMapper;
import org.jeecg.modules.rdata.service.IStrRkDocService;
import org.jeecg.modules.rdata.util.PubUtil;
import org.jeecg.modules.rdata.vo.CheckResurt;
import org.jeecg.modules.rdata.vo.EsCheckResurt;
import org.jeecg.modules.rdata.vo.QueryRkDoc;
import org.jeecg.modules.rdata.vo.Util;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.util.ObjectUtils;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Description: 入库退厂单主表
 * @Author: jeecg-boot
 * @Date:   2021-04-22
 * @Version: V1.0
 */
@Service
@DS("multi-datasource1")
public class StrRkDocServiceImpl extends ServiceImpl<StrRkDocMapper, StrRkDoc> implements IStrRkDocService {

    @Override
    public CheckResurt checkAndput(QueryWrapper<StrRkDoc> queryWrapper, QueryRkDoc queryRkDoc, String copt) {
        String resultMessage="查询参数正常";
        CheckResurt checkResurt = new CheckResurt();
        //校验时间格式
        if(!Util.checkTimeFormat(queryRkDoc.getShrqStart())||!Util.checkTimeFormat(queryRkDoc.getShrqEnd())){
            resultMessage="审核日期时间格式错误";
            checkResurt.setResultMessage(resultMessage);
            return checkResurt;
        }
        //校验单据类别
        if(Strings.isEmpty(queryRkDoc.getDjlb())){
            resultMessage="请选择单据类别";
            checkResurt.setResultMessage(resultMessage);
            return checkResurt;
        }
        queryWrapper.eq(!Strings.isEmpty(queryRkDoc.getStoreCode()),"store_code",queryRkDoc.getStoreCode())
                .like(!Strings.isEmpty(queryRkDoc.getGysName()),"gys_name",queryRkDoc.getGysName())
                .eq(!Strings.isEmpty(queryRkDoc.getGys()),"gys",queryRkDoc.getGys())
                .eq(!Strings.isEmpty(queryRkDoc.getDdbh()),"ddbh",queryRkDoc.getDdbh())
                .eq(!Strings.isEmpty(queryRkDoc.getDjlb()),"djlb",queryRkDoc.getDjlb())
                .ge(!Strings.isEmpty(queryRkDoc.getShrqStart()),"shrq",queryRkDoc.getShrqStart())
                .le(!Strings.isEmpty(queryRkDoc.getShrqEnd()),"shrq",queryRkDoc.getShrqEnd())
                .eq(!Strings.isEmpty(queryRkDoc.getDjbh()),"djbh",queryRkDoc.getDjbh())
                .eq("shbz","Y")//入库单只查询已审核的，退厂单只查询已退厂的
                .eq("copt",copt)
                .orderByDesc("shrq");

        checkResurt.setResultMessage(resultMessage);
        checkResurt.setQueryWrapper(queryWrapper);
        return checkResurt;
    }

    @Override
    public EsCheckResurt checkAndput(BoolQueryBuilder query, QueryRkDoc queryRkDoc) {

        String resultMessage="查询参数正常";
        EsCheckResurt checkResurt = new EsCheckResurt();
        //校验时间格式
        if(!Util.checkTimeFormat(queryRkDoc.getShrqStart())||!Util.checkTimeFormat(queryRkDoc.getShrqEnd())){
            resultMessage="审核日期时间格式错误";
            checkResurt.setQuery(null);
            checkResurt.setResultMessage(resultMessage);
            return checkResurt;
        }
        //校验单据类别
        if(Strings.isEmpty(queryRkDoc.getDjlb())){
            resultMessage="请选择单据类别";
            checkResurt.setQuery(null);
            checkResurt.setResultMessage(resultMessage);
            return checkResurt;
        }
        //校验门店编码
        if(Strings.isEmpty(queryRkDoc.getStoreCode())){
            resultMessage="请选择门店";
            checkResurt.setQuery(null);
            checkResurt.setResultMessage(resultMessage);
            return checkResurt;
        }
        //拼接查询条件
//        MatchPhraseQueryBuilder dsquery = QueryBuilders.matchPhraseQuery("ds", ds);
//        query.must(dsquery);
        if(!Strings.isEmpty(queryRkDoc.getStoreCode())){
            String storeCode = queryRkDoc.getStoreCode();
            //多个门店查询时以逗号分隔
            if(storeCode.contains(",")){
                String[] split = storeCode.split(",");
                List<String> stores = Arrays.asList(split);
                TermsQueryBuilder storeCodesquery = QueryBuilders.termsQuery("store_code",stores);
                query.must(storeCodesquery);
            }else {
                MatchPhraseQueryBuilder storeCodesquery = QueryBuilders.matchPhraseQuery("store_code", storeCode);
                query.must(storeCodesquery);
            }
        }
        //供应商名称模糊查询
        if(!Strings.isEmpty(queryRkDoc.getGysName())){
            MatchPhraseQueryBuilder gysQuery = QueryBuilders.matchPhraseQuery("gys_name", queryRkDoc.getGysName());
            query.must(gysQuery);
        }
        //入库单 单据类别
        List<String> rk = Arrays.stream(new String[]{"A", "1", "2", "5", "7"}).collect(Collectors.toList());
        //退厂单 单据类别
        List<String> tc = Arrays.stream(new String[]{"B", "3", "4", "6", "8"}).collect(Collectors.toList());

//        //入库单只查询已审核的，退厂单只查询已退厂的
        if (rk.contains(queryRkDoc.getDjlb())){
            //入库单
            MatchPhraseQueryBuilder shbzQuery = QueryBuilders.matchPhraseQuery("shbz", "Y");
            query.must(shbzQuery);
        }else {
            //退厂单
            String[] status = {"y", "n"};
            TermsQueryBuilder shbzQuery = QueryBuilders.termsQuery("shbz", status);
            query.must(shbzQuery);
        }
        //查询单据类别
        JSONObject strRkDoc = (JSONObject)JSONObject.toJSON(queryRkDoc);
        //查询全部入库单
        if("A".equals(queryRkDoc.getDjlb())){
            TermsQueryBuilder djlbQuery = QueryBuilders.termsQuery("djlb", rk);
            query.must(djlbQuery);
        }else if("B".equals(queryRkDoc.getDjlb())){
            //查询全部退厂单
            TermsQueryBuilder djlbQuery = QueryBuilders.termsQuery("djlb", tc);
            query.must(djlbQuery);
        }else {
            MatchPhraseQueryBuilder djlbQuery = QueryBuilders.matchPhraseQuery("djlb", queryRkDoc.getDjlb());
            query.must(djlbQuery);
        }


        //选择供应商
        if(!Strings.isEmpty(queryRkDoc.getGys())){

            String gys = queryRkDoc.getGys();
            //多个供应商查询时以逗号分隔
            if(gys.contains(",")){
                String[] split = gys.split(",");
                List<String> gyss = Arrays.asList(split);
                TermsQueryBuilder storeCodesquery = QueryBuilders.termsQuery("gys",gyss);
                query.must(storeCodesquery);
            }else {
                MatchPhraseQueryBuilder storeCodesquery = QueryBuilders.matchPhraseQuery("gys", gys);
                query.must(storeCodesquery);
            }
        }

        //模糊查询字段
        String[] dimFields = {"ddbh","djbh"};
        for (String field : dimFields) {
            if(!ObjectUtils.isEmpty(strRkDoc.getOrDefault(field,""))){
                WildcardQueryBuilder dimFieldQuery = QueryBuilders.wildcardQuery(field, "*"+strRkDoc.getOrDefault(field,"")+"*");
                query.must(dimFieldQuery);
            }
        }
        // 设置时间范围
        if (!Strings.isEmpty(queryRkDoc.getShrqStart()))
            query.filter(QueryBuilders.rangeQuery("shrq").gte(queryRkDoc.getShrqStart()));
        if (!Strings.isEmpty(queryRkDoc.getShrqEnd()))
            query.filter(QueryBuilders.rangeQuery("shrq").lte(LocalDate.parse(queryRkDoc.getShrqEnd()).plusDays(1).format(PubUtil.df)));

        checkResurt.setQuery(query);
        return checkResurt;
    }
}
