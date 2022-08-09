package org.jeecg.modules.rdata.vo;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.jeecgframework.poi.excel.annotation.Excel;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="query_dd_doc", description="订单查询条件")
public class QueryDdDoc {
    /** 门店编码 */
    @JsonProperty(value = "storeCode")
    @ApiModelProperty(value = "门店编码",name = "storeCode",required = true)
    private String storeCode;

    /** 供应商名称 */
    @JsonProperty(value = "supplierName")
    @ApiModelProperty(value = "供应商名称",name = "supplierName")
    private String gysName;

    /** 供应商编码 */
    @JsonProperty(value = "supplierCode")
    @ApiModelProperty(value = "供应商编码",name = "supplierCode")
    private String gys;

    /** 订单编号 */
    @JsonProperty(value = "orderNo")
    @ApiModelProperty(value = "订单编号",name = "orderNo")
    private String djbh;

    /** 订货日期始 */
    @ApiModelProperty(value = "订货日期始",name = "orderDateStart")
    @JsonProperty(value = "orderDateStart")
    private String dhrqStart;

    /** 订货日期终 */
    @ApiModelProperty(value = "订货日期终",name = "orderDateEnd")
    @JsonProperty(value = "orderDateEnd")
    private String dhrqEnd;

    /**单据类别*/
    @ApiModelProperty(value = "单据类别",name = "documentsCategory")
    @JsonProperty(value = "documentsCategory")
    private String djlb;

    /**订货标志*/
    @ApiModelProperty(value = "订货标志",name = "documentsCategory")
    @JsonProperty(value = "auditStatus")
    private String shbz;

    /**页码*/
    @ApiModelProperty(value = "页码",name = "pageNo")
    private Integer pageNo=1;

    /**页码*/
    @ApiModelProperty(value = "页容量",name = "pageSize")
    private Integer pageSize=10;

}
