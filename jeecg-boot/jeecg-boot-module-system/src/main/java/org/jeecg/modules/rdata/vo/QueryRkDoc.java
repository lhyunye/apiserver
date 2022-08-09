package org.jeecg.modules.rdata.vo;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="queryRkDoc", description="入库单查询条件")
public class QueryRkDoc {
    /** 门店编码 */
    @ApiModelProperty(value = "门店编码")
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
    private String ddbh;

    /** 入库单编号 */
    @JsonProperty(value = "voucherNo")
    @ApiModelProperty(value = "入库单编号",name = "voucherNo")
    private String djbh;

    /** 审核日期始 */
    @JsonProperty(value = "auditDateStart")
    @ApiModelProperty(value = "审核日期始",name = "auditDateStart")
    private String shrqStart;

    /** 订货日期终 */
    @JsonProperty(value = "auditDateEnd")
    @ApiModelProperty(value = "审核日期终",name = "auditDateEnd")
    private String shrqEnd;

    /**单据类别*/
    @ApiModelProperty(value = "单据类别",name = "documentsCategory")
    @JsonProperty(value = "documentsCategory")
    private String djlb;

    /**页码*/
    @ApiModelProperty(value = "页码",name = "pageNo")
    private Integer pageNo=1;

    /**页码*/
    @ApiModelProperty(value = "页容量",name = "pageSize")
    private Integer pageSize=10;



}
