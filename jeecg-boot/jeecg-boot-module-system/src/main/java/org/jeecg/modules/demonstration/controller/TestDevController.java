package org.jeecg.modules.demonstration.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.demonstration.entity.TestDev;
import org.jeecg.modules.demonstration.service.ITestDevService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;

 /**
 * @Description: 测试表生成
 * @Author: jeecg-boot
 * @Date:   2021-07-27
 * @Version: V1.0
 */
@RestController
@RequestMapping("/demonstration/testDev")
@Api(tags="验证")
@Slf4j
public class TestDevController extends JeecgController<TestDev, ITestDevService>{
	@Autowired
	private ITestDevService testDevService;
	
	/**
	 * 分页列表查询
	 *
	 * @param testDev
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@GetMapping(value = "/rootList")
	@ApiOperation("查询接口")
	public Result<?> queryPageList(TestDev testDev,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		String parentId = testDev.getPid();
		if (oConvertUtils.isEmpty(parentId)) {
			parentId = "0";
		}
		testDev.setPid(null);
		QueryWrapper<TestDev> queryWrapper = QueryGenerator.initQueryWrapper(testDev, req.getParameterMap());
		// 使用 eq 防止模糊查询
		queryWrapper.eq("pid", parentId);
		Page<TestDev> page = new Page<TestDev>(pageNo, pageSize);
		IPage<TestDev> pageList = testDevService.page(page, queryWrapper);
		return Result.ok(pageList);
	}

	 /**
      * 获取子数据
      * @param testTree
      * @param req
      * @return
      */
	@GetMapping(value = "/childList")
	public Result<?> queryPageList(TestDev testDev,HttpServletRequest req) {
		QueryWrapper<TestDev> queryWrapper = QueryGenerator.initQueryWrapper(testDev, req.getParameterMap());
		List<TestDev> list = testDevService.list(queryWrapper);
		return Result.ok(list);
	}
	
	
	/**
	 *   添加
	 *
	 * @param testDev
	 * @return
	 */
	@PostMapping(value = "/add")
	public Result<?> add(@RequestBody TestDev testDev) {
		testDevService.addTestDev(testDev);
		return Result.ok("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param testDev
	 * @return
	 */
	@PutMapping(value = "/edit")
	public Result<?> edit(@RequestBody TestDev testDev) {
		testDevService.updateTestDev(testDev);
		return Result.ok("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/delete")
	public Result<?> delete(@RequestParam(name="id",required=true) String id) {
		testDevService.deleteTestDev(id);
		return Result.ok("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@DeleteMapping(value = "/deleteBatch")
	public Result<?> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.testDevService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.ok("批量删除成功！");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/queryById")
	public Result<?> queryById(@RequestParam(name="id",required=true) String id) {
		TestDev testDev = testDevService.getById(id);
		if(testDev==null) {
			return Result.error("未找到对应数据");
		}
		return Result.ok(testDev);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param testDev
    */
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, TestDev testDev) {
		return super.exportXls(request, testDev, TestDev.class, "测试表生成");
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
		return super.importExcel(request, response, TestDev.class);
    }

}
