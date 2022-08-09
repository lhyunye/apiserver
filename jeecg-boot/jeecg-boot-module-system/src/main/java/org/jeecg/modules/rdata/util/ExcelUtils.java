package org.jeecg.modules.rdata.util;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import org.apache.poi.ss.usermodel.Workbook;

import org.jeecgframework.poi.excel.def.NormalExcelConstants;


import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

public class ExcelUtils {

    /**
     * 导出excel
     *
     * @param title      文件标题
     * @param clazz      实体类型
     * @param exportList 导出数据
     * @param <T>
     * @return
     */
    public static <T> ModelAndView export(String title, Class<T> clazz, List<T> exportList) {
        ModelAndView mv = new ModelAndView(new JeecgEntityExcelView());
        mv.addObject(NormalExcelConstants.FILE_NAME, title);
        mv.addObject(NormalExcelConstants.CLASS, clazz);
        mv.addObject(NormalExcelConstants.PARAMS, new ExportParams(title, title));
        mv.addObject(NormalExcelConstants.DATA_LIST, exportList);
        return mv;
    }

    /**
     * 导出excel
     *
     * @param list 数据集合
     * @param pojoClass 数据类型
     * @param fileName 文件名称
     * @param title 表明
     * @param response 响应对象
     */
    public static void exportExcel(List<?> list, Class<?> pojoClass, String fileName, String title, HttpServletResponse response) {
        ExportParams exportParams = new ExportParams(title, title);
        exportParams.setType(ExcelType.HSSF);
        // 自定义字典查询规则
        //exportParams.setDictHandler(new IExcelDictHandlerImpl());
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, pojoClass, list);
        if (workbook != null) {
            try {
                response.setCharacterEncoding("UTF-8");
                response.setHeader("content-Type", "application/vnd.ms-excel");
                response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8") + ".xls");
                workbook.write(response.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}
