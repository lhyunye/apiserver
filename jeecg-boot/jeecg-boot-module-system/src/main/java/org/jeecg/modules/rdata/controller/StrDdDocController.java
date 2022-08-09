package org.jeecg.modules.rdata.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import org.elasticsearch.common.Strings;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchPhraseQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.util.RedisUtil;
import org.jeecg.common.util.oConvertUtils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecg.modules.rdata.entity.InvMain;
import org.jeecg.modules.rdata.entity.StrDdCom;
import org.jeecg.modules.rdata.entity.StrDdDoc;
import org.jeecg.modules.rdata.entity.StrRkDoc;
import org.jeecg.modules.rdata.service.IStrDdComService;
import org.jeecg.modules.rdata.service.IStrDdDocService;
import org.jeecg.modules.rdata.util.ElasticsearchUtil;
import org.jeecg.modules.rdata.util.EsPage;
import org.jeecg.modules.rdata.util.PubUtil;
import org.jeecg.modules.rdata.vo.*;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;

 /**
 * @Description: 订单主表
 * @Author: jeecg-boot
 * @Date:   2021-04-22
 * @Version: V1.0
 */
@Api(tags="订单主表")
@RestController
@RequestMapping("/rdata/strDdDoc")
@Slf4j
public class StrDdDocController extends JeecgController<StrDdDoc, IStrDdDocService> {
	@Autowired
	private IStrDdDocService strDdDocService;

	@Autowired
	private IStrDdComService strDdComService;

	@Autowired
	private RedisUtil redisUtil;

	 @Autowired
	 private CodeFktj codeFktj;

	 @Value("${esquery.suffix}")
	 private String indexSuffix;

	 //es订单主单表
	 private String indexdoc = "es_str_dd_doc_dd";
	 //es订单明细表
	 private String indexcom = "es_str_dd_com_dd";


/*---------------------------------------------------------------------------------------*/

	 /**
	  * 分页列表查询
	  *
	  * @param strDdDoc
	  * @param req
	  * @return
	  */
	 @AutoLog(value = "订单主表-分页列表查询_es")
	 @ApiOperation(value="订单主表-分页列表查询_es", notes="订单主表-分页列表查询_es")
	 @PostMapping (value = "/list_es")
	 public Result<?> queryPageList_es(@RequestBody QueryDdDoc strDdDoc,
									HttpServletRequest req) {
		 //校验门店编码
		 if(Strings.isEmpty(strDdDoc.getStoreCode())){
			 //数据库无数据
			 return Result.error("请选择门店编码");
		 }
		 //获取最大数据版本
//		 String ds = PubUtil.getMaxDs(indexdoc+indexSuffix+"&"+strDdDoc.getStoreCode(),redisUtil);
//		 if (Strings.isEmpty(ds)) {
//			 //数据库无数据
//			 return Result.error("数据库无数据");
//		 }
		 Integer pageNo = strDdDoc.getPageNo();
		 Integer pageSize = strDdDoc.getPageSize();
		 BoolQueryBuilder query = QueryBuilders.boolQuery();
		 //检查入参并生成查询条件
		 EsCheckResurt checkResurt = strDdDocService.checkAndput(query, strDdDoc);
		 query = checkResurt.getQuery();

		 if(ObjectUtils.isEmpty(query)){
			 return Result.error(checkResurt.getResultMessage());
		 }
		 EsPage esPage = ElasticsearchUtil.searchDataPage(indexdoc+indexSuffix, "first", pageNo - 1, pageSize, query, "", "dhrq,djbh", "");

		 List<Map<String, Object>> recordList = esPage.getRecordList();
		 List<StrDdDoc> records = new ArrayList<>();
		 int rowNo = (pageNo-1)*pageSize+1;
		 for (int i = 0;i<recordList.size();i++){
			 StrDdDoc strDdDocMsg = JSON.toJavaObject((JSON) JSON.toJSON(recordList.get(i)), StrDdDoc.class);
			 strDdDocMsg.setRowNo(rowNo);
			 rowNo++;
			 records.add(strDdDocMsg);
		 }

		 IPage<StrDdDoc> pageList = new Page<>();
		 pageList.setPages(esPage.getPageCount());
		 pageList.setCurrent(pageNo);
		 pageList.setSize(pageSize);
		 pageList.setTotal(esPage.getRecordCount());
		 pageList.setRecords(records);

		 return Result.ok(pageList);
	 }


	 /**
	  * 通过id查询
	  *
	  * @param seqno
	  * @return
	  */
	 @AutoLog(value = "订单主表-通过id查询_es")
	 @ApiOperation(value="订单主表-通过id查询_es", notes="订单主表-通过id查询_es")
	 @GetMapping(value = "/queryById_es")
	 public Result<?> queryById_es(@RequestParam(name="serialNo",required=true) String seqno,@RequestParam(name = "storeCode",required = true) String storeCode) {
		 if (Strings.isEmpty(storeCode)) {
			 return Result.error("未填写门店编码");
		 }
	 	//获取最大数据版本
//		 String ds = PubUtil.getMaxDs(indexcom+indexSuffix+"&"+storeCode,redisUtil);
//		 if (Strings.isEmpty(ds)) {
//			 //数据库无数据
//			 return Result.error("数据库无数据");
//		 }
		 if (Strings.isEmpty(seqno)) {
			 return Result.error("未填写订单号");
		 }

		 //获取主表详情
		 BoolQueryBuilder queryDoc = QueryBuilders.boolQuery();
		 MatchPhraseQueryBuilder seqnoQuery = QueryBuilders.matchPhraseQuery("seqno", seqno);
		 queryDoc.must(seqnoQuery);
		 MatchPhraseQueryBuilder codeQuery = QueryBuilders.matchPhraseQuery("store_code", storeCode);
		 queryDoc.must(codeQuery);
//		 MatchPhraseQueryBuilder dsQuery = QueryBuilders.matchPhraseQuery("ds", ds);
//		 queryDoc.must(dsQuery);
		 List<Map<String, Object>> doclist = ElasticsearchUtil.searchListData(indexdoc+indexSuffix, "first", queryDoc, null, "", "", "");
		 List<StrDdDoc> records = doclist.stream().map(x ->
				 JSON.toJavaObject((JSON) JSON.toJSON(x), StrDdDoc.class)
		 ).collect(Collectors.toList());
		 if(ObjectUtils.isEmpty(records)||records.size()<1) {
			 return Result.error("未找到对应数据");
		 }
		 //主表详情
		 StrDdDoc strDdDoc = records.get(0);
		 // 补充主表付款代码字典值
		 strDdDoc.setPayCodeValue(codeFktj.getMsg(strDdDoc.getStoreCode(),strDdDoc.getPayCode()));


		 //获取明细详情列表
		 BoolQueryBuilder queryCom = QueryBuilders.boolQuery();
		 MatchPhraseQueryBuilder ddbhQuery = QueryBuilders.matchPhraseQuery("ddbh", seqno);
		 queryCom.must(ddbhQuery);
		 queryCom.must(codeQuery);
		 List<Map<String, Object>> comlist = ElasticsearchUtil.searchListData(indexcom+indexSuffix, "first", queryCom, 200, "", "rowno,asc", "");

		 List<StrDdCom> comRecords = comlist.stream().map(x ->

				 JSON.toJavaObject((JSON) JSON.toJSON(x), StrDdCom.class)
		 ).map(x->
			 //零售金额 = 应收金额 + 会员折扣 + 非会员折扣
			 x.setTax(new BigDecimal(x.getTaxCost()).subtract(new BigDecimal(x.getCost())).toString())
		 ).collect(Collectors.toList());

		 StrDdDocModel strDdDocModel = new StrDdDocModel();
		 strDdDocModel.setStrDdDoc(strDdDoc);
		 strDdDocModel.setStrDdComs(comRecords);
		 return Result.ok(strDdDocModel);
	 }











	 /*-------------------------下面接口无用-----------------------------------------------*/

	/**
	 *   添加
	 *
	 * @param strDdDoc
	 * @return
	 */
	@AutoLog(value = "订单主表-添加")
	//@ApiOperation(value="订单主表-添加", notes="订单主表-添加")
	@PostMapping(value = "/add")
	public Result<?> add(@RequestBody StrDdDoc strDdDoc) {
		strDdDocService.save(strDdDoc);
		return Result.ok("添加成功！");
	}

	/**
	 *  编辑
	 *
	 * @param strDdDoc
	 * @return
	 */
	@AutoLog(value = "订单主表-编辑")
	//@ApiOperation(value="订单主表-编辑", notes="订单主表-编辑")
	@PutMapping(value = "/edit")
	public Result<?> edit(@RequestBody StrDdDoc strDdDoc) {
		strDdDocService.updateById(strDdDoc);
		return Result.ok("编辑成功!");
	}

	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "订单主表-通过id删除")
	//@ApiOperation(value="订单主表-通过id删除", notes="订单主表-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<?> delete(@RequestParam(name="id",required=true) String id) {
		strDdDocService.removeById(id);
		return Result.ok("删除成功!");
	}

	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "订单主表-批量删除")
	//@ApiOperation(value="订单主表-批量删除", notes="订单主表-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<?> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.strDdDocService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.ok("批量删除成功!");
	}



    /**
    * 导出excel
    *
    * @param request
    * @param strDdDoc
    */
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, StrDdDoc strDdDoc) {
        return super.exportXls(request, strDdDoc, StrDdDoc.class, "订单主表");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, StrDdDoc.class);
    }

}
