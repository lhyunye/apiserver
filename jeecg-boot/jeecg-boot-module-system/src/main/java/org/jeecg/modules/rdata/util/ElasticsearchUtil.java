package org.jeecg.modules.rdata.util;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequest;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequestBuilder;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.search.MultiMatchQuery;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.histogram.Histogram;
import org.elasticsearch.search.aggregations.bucket.terms.*;
import org.elasticsearch.search.collapse.CollapseBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.hibernate.validator.resourceloading.AggregateResourceBundleLocator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
@Slf4j
public class ElasticsearchUtil {



    @Autowired
    private TransportClient transportClient;

    @Autowired
    private static TransportClient client;

    /**
     * @PostContruct???spring??????????????? spring???????????????????????????????????????
     */
    @PostConstruct
    public void init() {
        client = this.transportClient;
    }

    /**
     * ????????????
     *
     * @param index
     * @return
     */
    public static boolean createIndex(String index) {
        if (!isIndexExist(index)) {
            log.info("Index is not exits!");
        }
        CreateIndexResponse indexresponse = client.admin().indices().prepareCreate(index).execute().actionGet();
        log.info("?????????????????????" + indexresponse.isAcknowledged());
        return indexresponse.isAcknowledged();
    }

    /**
     * ????????????
     *
     * @param index
     * @return
     */
    public static boolean deleteIndex(String index) {
        if (!isIndexExist(index)) {
            log.info("Index is not exits!");
        }
        DeleteIndexResponse dResponse = client.admin().indices().prepareDelete(index).execute().actionGet();
        if (dResponse.isAcknowledged()) {
            log.info("delete index " + index + "  successfully!");
        } else {
            log.info("Fail to delete index " + index);
        }
        return dResponse.isAcknowledged();
    }

    /**
     * ????????????????????????
     *
     * @param index
     * @return
     */
    public static boolean isIndexExist(String index) {
        IndicesExistsResponse inExistsResponse = client.admin().indices().exists(new IndicesExistsRequest(index)).actionGet();
        if (inExistsResponse.isExists()) {
            log.info("Index [" + index + "] is exist!");
        } else {
            log.info("Index [" + index + "] is not exist!");
        }
        return inExistsResponse.isExists();
    }

    /**
     * @Description: ??????inde?????????type????????????
     */
    public boolean isTypeExist(String index, String type) {
        return isIndexExist(index)
                ? client.admin().indices().prepareTypesExists(index).setTypes(type).execute().actionGet().isExists()
                : false;
    }

    /**
     * ?????????????????????ID
     *
     * @param jsonObject ??????????????????
     * @param index      ????????????????????????
     * @param type       ??????????????????
     * @param id         ??????ID
     * @return
     */
    public static String addData(JSONObject jsonObject, String index, String type, String id) {
        IndexResponse response = client.prepareIndex(index, type, id).setSource(jsonObject).get();
        log.info("addData response status:{},id:{}", response.status().getStatus(), response.getId());
        return response.getId();
    }

    /**
     * ????????????
     *
     * @param jsonObject ??????????????????
     * @param index      ????????????????????????
     * @param type       ??????????????????
     * @return
     */
    public static String addData(JSONObject jsonObject, String index, String type) {
        return addData(jsonObject, index, type, UUID.randomUUID().toString().replaceAll("-", "").toUpperCase());
    }

    /**
     * ??????ID????????????
     *
     * @param index ????????????????????????
     * @param type  ??????????????????
     * @param id    ??????ID
     */
    public static void deleteDataById(String index, String type, String id) {

        DeleteResponse response = client.prepareDelete(index, type, id).execute().actionGet();

        log.info("deleteDataById response status:{},id:{}", response.status().getStatus(), response.getId());
    }

    /**
     * ??????ID ????????????
     *
     * @param jsonObject ??????????????????
     * @param index      ????????????????????????
     * @param type       ??????????????????
     * @param id         ??????ID
     * @return
     */
    public static void updateDataById(JSONObject jsonObject, String index, String type, String id) {

        UpdateRequest updateRequest = new UpdateRequest();

        updateRequest.index(index).type(type).id(id).doc(jsonObject);

        client.update(updateRequest);

    }

    /**
     * ??????ID????????????
     *
     * @param index  ????????????????????????
     * @param type   ??????????????????
     * @param id     ??????ID
     * @param fields ???????????????????????????????????????????????????????????????
     * @return
     */
    public static Map<String, Object> searchDataById(String index, String type, String id, String fields) {

        GetRequestBuilder getRequestBuilder = client.prepareGet(index, type, id);

        if (StringUtils.isNotEmpty(fields)) {
            getRequestBuilder.setFetchSource(fields.split(","), null);
        }

        GetResponse getResponse = getRequestBuilder.execute().actionGet();

        return getResponse.getSource();
    }


    /**
     * ??????????????????,?????????
     *
     * @param index          ????????????
     * @param type           ????????????,???????????????type????????????
     * @param startPage      ?????????
     * @param pageSize       ??????????????????
     * @param query          ????????????
     * @param fields         ???????????????????????????????????????????????????????????????
     * @param sortField      ????????????
     * @param highlightField ????????????
     * @return
     */
    public static EsPage searchDataPage(String index, String type, int startPage, int pageSize, QueryBuilder query, String fields, String sortField, String highlightField) {
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch(index);
        if (StringUtils.isNotEmpty(type)) {
            searchRequestBuilder.setTypes(type.split(","));
        }
        searchRequestBuilder.setSearchType(SearchType.QUERY_THEN_FETCH);

        // ???????????????????????????????????????????????????????????????
        if (StringUtils.isNotEmpty(fields)) {
            searchRequestBuilder.setFetchSource(fields.split(","), null);
        }

        //????????????
        if (StringUtils.isNotEmpty(sortField)) {
            if (sortField.contains(",")){
                String[] split = sortField.split(",");
                for (String s : split) {
                    searchRequestBuilder.addSort(s,SortOrder.DESC);
                }

            }else {
                searchRequestBuilder.addSort(sortField, SortOrder.DESC);
            }


        }

        // ?????????xxx=111,aaa=222???
        if (StringUtils.isNotEmpty(highlightField)) {
            HighlightBuilder highlightBuilder = new HighlightBuilder();

            //highlightBuilder.preTags("<span style='color:red' >");//????????????
            //highlightBuilder.postTags("</span>");//????????????

            // ??????????????????
            highlightBuilder.field(highlightField);
            searchRequestBuilder.highlighter(highlightBuilder);
        }

        //searchRequestBuilder.setQuery(QueryBuilders.matchAllQuery());
        searchRequestBuilder.setQuery(query);



        // ????????????
        int fromNum = startPage * pageSize;
        searchRequestBuilder.setFrom(fromNum).setSize(pageSize);

        // ????????????????????????????????????
        searchRequestBuilder.setExplain(true);

        //??????????????? ????????? Elasticsearch head ??? Kibana  ???????????????
        log.info("\n{}", searchRequestBuilder);

        // ????????????,????????????????????????
        SearchResponse searchResponse = searchRequestBuilder.execute().actionGet();

        long totalHits = searchResponse.getHits().totalHits;
        long length = searchResponse.getHits().getHits().length;

        log.debug("????????????[{}]?????????,??????????????????[{}]", totalHits, length);

        if (searchResponse.status().getStatus() == 200) {
            // ????????????
            List<Map<String, Object>> sourceList = setSearchResponse(searchResponse, highlightField);

            return new EsPage(startPage, pageSize, (int) totalHits, sourceList);
        }

        return null;

    }

    /**
     * ??????????????????,?????????,?????????
     *
     * @param index          ????????????
     * @param type           ????????????,???????????????type????????????
     * @param startPage      ?????????
     * @param pageSize       ??????????????????
     * @param query          ????????????
     * @param fields         ???????????????????????????????????????????????????????????????
     * @param sortField      ????????????
     * @param highlightField ????????????
     * @param foldField ????????????
     * @return
     */
    public static List<String> searchDataPageByFold(String index, String type, int startPage, int pageSize, QueryBuilder query, String fields, String sortField, String highlightField, String foldField) {
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch(index);
        if (StringUtils.isNotEmpty(type)) {
            searchRequestBuilder.setTypes(type.split(","));
        }
        searchRequestBuilder.setSearchType(SearchType.QUERY_THEN_FETCH);

        // ???????????????????????????????????????????????????????????????
        if (StringUtils.isNotEmpty(fields)) {
            searchRequestBuilder.setFetchSource(fields.split(","), null);
        }

        //????????????
        if (StringUtils.isNotEmpty(sortField)) {
            searchRequestBuilder.addSort(sortField, SortOrder.DESC);
        }

        // ?????????xxx=111,aaa=222???
        if (StringUtils.isNotEmpty(highlightField)) {
            HighlightBuilder highlightBuilder = new HighlightBuilder();

            //highlightBuilder.preTags("<span style='color:red' >");//????????????
            //highlightBuilder.postTags("</span>");//????????????

            // ??????????????????
            highlightBuilder.field(highlightField);
            searchRequestBuilder.highlighter(highlightBuilder);
        }

        // ??????????????????
        if (StringUtils.isNotEmpty(foldField)) {

            TermsAggregationBuilder app = AggregationBuilders.terms("app").size(10000).field(foldField );

            searchRequestBuilder.addAggregation(app);
        }

        //searchRequestBuilder.setQuery(QueryBuilders.matchAllQuery());
        searchRequestBuilder.setQuery(query);



        // ????????????
        searchRequestBuilder.setFrom(startPage).setSize(pageSize);

        // ????????????????????????????????????
        searchRequestBuilder.setExplain(true);

        //??????????????? ????????? Elasticsearch head ??? Kibana  ???????????????
        log.info("\n{}", searchRequestBuilder);

        // ????????????,????????????????????????
        SearchResponse searchResponse = searchRequestBuilder.execute().actionGet();
        Aggregations aggregations = searchResponse.getAggregations();
        Map<String, Object> app2 = aggregations.asMap().get("app").getMetaData();
        System.out.println(app2);

        StringTerms  app = (StringTerms)aggregations.asMap().get("app");
        Iterator<StringTerms.Bucket> foldBucketIt  = app.getBuckets().iterator();
        List<String> foldList = new ArrayList<>();
        while(foldBucketIt.hasNext())
        {
            StringTerms.Bucket foldBucketItt = foldBucketIt.next();
            foldList.add((String) foldBucketItt.getKey());
        }





        log.debug("????????????[{}]?????????", foldList.size());

        if (searchResponse.status().getStatus() == 200) {


            return foldList;
        }

        return null;

    }


    /**
     * ??????????????????,?????????,?????????
     *
     * @param index          ????????????
     * @param type           ????????????,???????????????type????????????
     * @param startPage      ?????????
     * @param pageSize       ??????????????????
     * @param query          ????????????
     * @param fields         ???????????????????????????????????????????????????????????????
     * @param sortField      ????????????
     * @param highlightField ????????????
     * @param foldField ????????????
     * @return
     */
    public static List<String> searchDataPageByFoldDouble(String index, String type, int startPage, int pageSize, QueryBuilder query, String fields, String sortField, String highlightField, String foldField) {
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch(index);
        if (StringUtils.isNotEmpty(type)) {
            searchRequestBuilder.setTypes(type.split(","));
        }
        searchRequestBuilder.setSearchType(SearchType.QUERY_THEN_FETCH);

        // ???????????????????????????????????????????????????????????????
        if (StringUtils.isNotEmpty(fields)) {
            searchRequestBuilder.setFetchSource(fields.split(","), null);
        }

        //????????????
        if (StringUtils.isNotEmpty(sortField)) {
            searchRequestBuilder.addSort(sortField, SortOrder.DESC);
        }

        // ?????????xxx=111,aaa=222???
        if (StringUtils.isNotEmpty(highlightField)) {
            HighlightBuilder highlightBuilder = new HighlightBuilder();

            //highlightBuilder.preTags("<span style='color:red' >");//????????????
            //highlightBuilder.postTags("</span>");//????????????

            // ??????????????????
            highlightBuilder.field(highlightField);
            searchRequestBuilder.highlighter(highlightBuilder);
        }

        // ??????????????????
        if (StringUtils.isNotEmpty(foldField)) {

            TermsAggregationBuilder app = AggregationBuilders.terms("app").size(10000).field(foldField );

            searchRequestBuilder.addAggregation(app);
        }

        //searchRequestBuilder.setQuery(QueryBuilders.matchAllQuery());
        searchRequestBuilder.setQuery(query);



        // ????????????
        searchRequestBuilder.setFrom(startPage).setSize(pageSize);

        // ????????????????????????????????????
        searchRequestBuilder.setExplain(true);

        //??????????????? ????????? Elasticsearch head ??? Kibana  ???????????????
        log.info("\n{}", searchRequestBuilder);

        // ????????????,????????????????????????
        SearchResponse searchResponse = searchRequestBuilder.execute().actionGet();
        Aggregations aggregations = searchResponse.getAggregations();


        ParsedStringTerms  app2 = (ParsedStringTerms)aggregations.asMap().get("app");
        List<String> foldList = new ArrayList<>();
        for(Terms.Bucket entry : app2.getBuckets()){
            foldList.add((String) entry.getKey());

        }







        log.debug("????????????[{}]?????????", foldList.size());

        if (searchResponse.status().getStatus() == 200) {


            return foldList;
        }

        return null;

    }
    /**
     * ??????????????????
     *
     * @param index          ????????????
     * @param type           ????????????,???????????????type????????????
     * @param query          ????????????
     * @param size           ??????????????????
     * @param fields         ???????????????????????????????????????????????????????????????
     * @param sortField      ????????????
     * @param highlightField ????????????
     * @return
     */
    public static List<Map<String, Object>> searchListData(
            String index, String type, QueryBuilder query, Integer size,
            String fields, String sortField, String highlightField) {

        SearchRequestBuilder searchRequestBuilder = client.prepareSearch(index);
        if (StringUtils.isNotEmpty(type)) {
            searchRequestBuilder.setTypes(type.split(","));
        }

        if (StringUtils.isNotEmpty(highlightField)) {
            HighlightBuilder highlightBuilder = new HighlightBuilder();
            // ??????????????????
            highlightBuilder.field(highlightField);
            searchRequestBuilder.highlighter(highlightBuilder);
        }

        searchRequestBuilder.setQuery(query);

        if (StringUtils.isNotEmpty(fields)) {
            searchRequestBuilder.setFetchSource(fields.split(","), null);
        }
        searchRequestBuilder.setFetchSource(true);

        if (StringUtils.isNotEmpty(sortField)) {
            if (sortField.contains(",")){
                String[] split = sortField.split(",");
                searchRequestBuilder.addSort(split[0], SortOrder.ASC);
            }else {
                searchRequestBuilder.addSort(sortField, SortOrder.DESC);
            }

        }

        if (size != null && size > 0) {
            searchRequestBuilder.setSize(size);
        }

        //??????????????? ????????? Elasticsearch head ??? Kibana  ???????????????
        log.info("\n{}", searchRequestBuilder);

        SearchResponse searchResponse = searchRequestBuilder.execute().actionGet();

        long totalHits = searchResponse.getHits().totalHits;
        long length = searchResponse.getHits().getHits().length;

        log.info("????????????[{}]?????????,??????????????????[{}]", totalHits, length);

        if (searchResponse.status().getStatus() == 200) {
            // ????????????
            return setSearchResponse(searchResponse, highlightField);
        }
        return null;

    }


    /**
     * ??????????????? ????????????
     *
     * @param searchResponse
     * @param highlightField
     */
    private static List<Map<String, Object>> setSearchResponse(SearchResponse searchResponse, String highlightField) {
        List<Map<String, Object>> sourceList = new ArrayList<Map<String, Object>>();
        StringBuffer stringBuffer = new StringBuffer();

        for (SearchHit searchHit : searchResponse.getHits().getHits()) {
            searchHit.getSourceAsMap().put("id", searchHit.getId());

            if (StringUtils.isNotEmpty(highlightField)) {

                System.out.println("?????? ???????????????????????? ???????????????" + searchHit.getSourceAsMap());
                Text[] text = searchHit.getHighlightFields().get(highlightField).getFragments();

                if (text != null) {
                    for (Text str : text) {
                        stringBuffer.append(str.string());
                    }
                    //?????? ???????????????????????? ???????????????
                    searchHit.getSourceAsMap().put(highlightField, stringBuffer.toString());
                }
            }
            sourceList.add(searchHit.getSourceAsMap());
        }
        return sourceList;
    }
}

