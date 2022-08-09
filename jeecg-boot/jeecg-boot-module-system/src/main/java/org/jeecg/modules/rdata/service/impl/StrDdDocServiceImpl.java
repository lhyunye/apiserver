package org.jeecg.modules.rdata.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.elasticsearch.common.Strings;
import org.elasticsearch.index.query.*;
import org.jeecg.modules.rdata.entity.StrDdDoc;
import org.jeecg.modules.rdata.mapper.StrDdDocMapper;
import org.jeecg.modules.rdata.service.IStrDdDocService;
import org.jeecg.modules.rdata.util.PubUtil;
import org.jeecg.modules.rdata.vo.CheckResurt;
import org.jeecg.modules.rdata.vo.EsCheckResurt;
import org.jeecg.modules.rdata.vo.QueryDdDoc;
import org.jeecg.modules.rdata.vo.Util;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.util.ObjectUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 订单主表
 * @Author: jeecg-boot
 * @Date:   2021-04-22
 * @Version: V1.0
 */
@Service
@DS("multi-datasource1")
public class StrDdDocServiceImpl extends ServiceImpl<StrDdDocMapper, StrDdDoc> implements IStrDdDocService {

    /**
     * 检测参数格式及设置查询条件
     * @param query 空查询条件
     * @param strDdDoc  查询参数
     * @param ds  数据版本
     * @return CheckResurt 返回查询结果及校验信息
     *
     * */
    @Override
    public EsCheckResurt checkAndput(BoolQueryBuilder query, QueryDdDoc strDdDoc) {
        String resultMessage="查询参数正常";
        EsCheckResurt checkResurt = new EsCheckResurt();

        //校验门店编码
        if(Strings.isEmpty(strDdDoc.getStoreCode())){
            resultMessage="请选择门店编码";
            checkResurt.setQuery(null);
            checkResurt.setResultMessage(resultMessage);
            return checkResurt;
        }
        //校验时间格式
        if(!Util.checkTimeFormat(strDdDoc.getDhrqStart())||!Util.checkTimeFormat(strDdDoc.getDhrqEnd())){
            resultMessage="订货日期时间格式错误";
            checkResurt.setQuery(null);
            checkResurt.setResultMessage(resultMessage);
            return checkResurt;
        }
        //拼接查询条件
        //数据版本选择
//        MatchPhraseQueryBuilder dsquery = QueryBuilders.matchPhraseQuery("ds", ds);
//        query.must(dsquery);
        //选则数据门店
        if(!Strings.isEmpty(strDdDoc.getStoreCode())){

            String storeCode = strDdDoc.getStoreCode();
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

        //选择供应商
        if(!Strings.isEmpty(strDdDoc.getGys())){

            String gys = strDdDoc.getGys();
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

        //模糊查询供应商名称
        if(!Strings.isEmpty(strDdDoc.getGysName())) {
            MatchPhraseQueryBuilder gysQuery = QueryBuilders.matchPhraseQuery("gys_name", strDdDoc.getGysName());
            query.must(gysQuery);
        }



        //匹配查询字段 单据类别
        String[] fields = {"djlb"};
        JSONObject strDdDocj = (JSONObject)JSONObject.toJSON(strDdDoc);
        for (String field : fields) {
            if(!ObjectUtils.isEmpty(strDdDocj.getOrDefault(field,""))){
                MatchPhraseQueryBuilder fieldQuery = QueryBuilders.matchPhraseQuery(field, strDdDocj.getOrDefault(field,"").toString());
                query.must(fieldQuery);
            }
        }


        //模糊查询字段
        String[] dimFields = {"djbh"};
        for (String field : dimFields) {
            if(!ObjectUtils.isEmpty(strDdDocj.getOrDefault(field,""))){
                WildcardQueryBuilder dimFieldQuery = QueryBuilders.wildcardQuery(field, "*"+strDdDocj.getOrDefault(field,"")+"*");
                query.must(dimFieldQuery);
            }
        }
        //筛选数据范围
        if (!Strings.isEmpty(strDdDoc.getDhrqStart()))
            query.filter(QueryBuilders.rangeQuery("dhrq").gte(strDdDoc.getDhrqStart()));
        if (!Strings.isEmpty(strDdDoc.getDhrqEnd()))
            query.filter(QueryBuilders.rangeQuery("dhrq").lte(LocalDate.parse(strDdDoc.getDhrqEnd()).plusDays(1).format(PubUtil.df)));

        //只查询已审核的订单
        String[] status = {"m", "s", "q", "y"};
        //（SHBZ）：M：已审核，S:未入库，Q：已取消，Y：已到货
        //筛选审核标志
        if(Strings.isEmpty(strDdDoc.getShbz())){
            TermsQueryBuilder shbzQuery = QueryBuilders.termsQuery("shbz", status);
            query.must(shbzQuery);
        }else {
            MatchPhraseQueryBuilder shbzQuery = QueryBuilders.matchPhraseQuery("shbz", strDdDoc.getShbz());
            query.must(shbzQuery);
        }

        checkResurt.setQuery(query);
        return checkResurt;
    }

    /**
     * 检测参数格式及设置查询条件
     * @param queryWrapper 空查询条件
     * @param queryDdDoc  查询参数
     * @param queryDdDoc  数据版本
     * @return CheckResurt 返回查询结果及校验信息
     *
     * */
    @Override
    public CheckResurt checkAndput(QueryWrapper<StrDdDoc> queryWrapper, QueryDdDoc queryDdDoc,String copt) {
        String resultMessage="查询参数正常";
        CheckResurt checkResurt = new CheckResurt();
        //校验时间格式
        if(!Util.checkTimeFormat(queryDdDoc.getDhrqStart())||!Util.checkTimeFormat(queryDdDoc.getDhrqEnd())){
            resultMessage="订货日期时间格式错误";
            checkResurt.setResultMessage(resultMessage);
            return checkResurt;
        }
        queryWrapper.eq(!Strings.isEmpty(queryDdDoc.getStoreCode()),"store_code",queryDdDoc.getStoreCode())
                .like(!Strings.isEmpty(queryDdDoc.getGysName()),"gys_name",queryDdDoc.getGysName())
                .eq(!Strings.isEmpty(queryDdDoc.getGys()),"gys",queryDdDoc.getGys())
                .eq(!Strings.isEmpty(queryDdDoc.getDjbh()),"djbh",queryDdDoc.getDjbh())
                .eq(!Strings.isEmpty(queryDdDoc.getDjlb()),"djlb",queryDdDoc.getDjlb())
                .ge(!Strings.isEmpty(queryDdDoc.getDhrqStart()),"dhrq",queryDdDoc.getDhrqStart())
                .le(!Strings.isEmpty(queryDdDoc.getDhrqEnd()),"dhrq",queryDdDoc.getDhrqEnd())
                .eq("shbz","M")//只查询已审核的订单
                .eq("copt",copt)
                .orderByDesc("shrq");

        checkResurt.setResultMessage(resultMessage);
        checkResurt.setQueryWrapper(queryWrapper);
        return checkResurt;
    }







}
