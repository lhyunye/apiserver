package org.jeecg.modules.dev.controller;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.modules.dev.entity.TestNew;
import org.jeecg.modules.dev.service.ITestNewService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;

 /**
 * @Description: 演示数据表
 * @Author: jeecg-boot
 * @Date:   2021-07-27
 * @Version: V1.0
 */
@Api(tags="演示数据表")
@RestController
@RequestMapping("/dev/testNew")
@Slf4j
public class TestNewController extends JeecgController<TestNew, ITestNewService> {
	@Autowired
	private ITestNewService testNewService;
	
	/**
	 * 分页列表查询
	 *
	 * @param testNew
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@AutoLog(value = "演示数据表-分页列表查询")
	@ApiOperation(value="演示数据表-分页列表查询", notes="演示数据表-分页列表查询")
	@GetMapping(value = "/list")
	public Result<?> queryPageList(TestNew testNew,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<TestNew> queryWrapper = QueryGenerator.initQueryWrapper(testNew, req.getParameterMap());
		Page<TestNew> page = new Page<TestNew>(pageNo, pageSize);
		IPage<TestNew> pageList = testNewService.page(page, queryWrapper);
		return Result.ok(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param testNew
	 * @return
	 */
	@AutoLog(value = "演示数据表-添加")
	@ApiOperation(value="演示数据表-添加", notes="演示数据表-添加")
	@PostMapping(value = "/add")
	public Result<?> add(@RequestBody TestNew testNew) {
		testNewService.save(testNew);
		return Result.ok("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param testNew
	 * @return
	 */
	@AutoLog(value = "演示数据表-编辑")
	@ApiOperation(value="演示数据表-编辑", notes="演示数据表-编辑")
	@PutMapping(value = "/edit")
	public Result<?> edit(@RequestBody TestNew testNew) {
		testNewService.updateById(testNew);
		return Result.ok("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "演示数据表-通过id删除")
	@ApiOperation(value="演示数据表-通过id删除", notes="演示数据表-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<?> delete(@RequestParam(name="id",required=true) String id) {
		testNewService.removeById(id);
		return Result.ok("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "演示数据表-批量删除")
	@ApiOperation(value="演示数据表-批量删除", notes="演示数据表-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<?> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.testNewService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.ok("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "演示数据表-通过id查询")
	@ApiOperation(value="演示数据表-通过id查询", notes="演示数据表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<?> queryById(@RequestParam(name="id",required=true) String id) {
		TestNew testNew = testNewService.getById(id);
		if(testNew==null) {
			return Result.error("未找到对应数据");
		}
		return Result.ok(testNew);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param testNew
    */
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, TestNew testNew) {
        return super.exportXls(request, testNew, TestNew.class, "演示数据表");
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
        return super.importExcel(request, response, TestNew.class);
    }

}
