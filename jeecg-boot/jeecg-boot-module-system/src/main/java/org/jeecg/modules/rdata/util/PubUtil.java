package org.jeecg.modules.rdata.util;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.*;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class PubUtil {


    public static DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    //获取最大数据版本
    public static String getMaxDs(String index,RedisUtil redisUtil){
        Object inv_main_ds = redisUtil.get(index);
        String[] value = index.split("&");

        String rindex = value[0];
        String storeCode = value[1];

        String ds = "";
        if (ObjectUtils.isEmpty(inv_main_ds)){
            BoolQueryBuilder query = QueryBuilders.boolQuery();
            if(storeCode.contains(",")){
                String[] stores = storeCode.split(",");
                TermsQueryBuilder storeCodeQuery = QueryBuilders.termsQuery("store_code", stores);
                query.must(storeCodeQuery);
            }else {
                if (!"allStore".equals(storeCode)) {
                    MatchPhraseQueryBuilder storeCodeQuery = QueryBuilders.matchPhraseQuery("store_code", storeCode);
                    query.must(storeCodeQuery);
                }
            }

            List<Map<String, Object>> list = ElasticsearchUtil.searchListData(rindex, "first", query, 1, "ds", "ds", "");
            if (list.size()>=1){
                ds = list.get(0).get("ds").toString();
                redisUtil.set(index,ds,600);
            }

        }else {
            ds = inv_main_ds.toString();
        }

        return ds;
    }


}
