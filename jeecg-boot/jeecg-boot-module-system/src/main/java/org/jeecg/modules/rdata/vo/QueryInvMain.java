package org.jeecg.modules.rdata.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="query_inv_main", description="小票主单查询条件")
public class QueryInvMain {

    /** 单据类别 */
    @ApiModelProperty(value = "单据类别，可多选 用‘，’分隔")
    private String djlb;

    /** 收银机号 */
    @ApiModelProperty(value = "收银机号")
    private String syjh;

    /** 收银员号 */
    @ApiModelProperty(value = "收银员号")
    private String syyh;

    /** 小票号 */
    @ApiModelProperty(value = "小票号")
    private String seqno;

    /** 会员卡号 */
    @ApiModelProperty(value = "会员卡号")
    private String hykh;

    /** 商品编码 */
    @ApiModelProperty(value = "商品编码")
    private String comCode;

    /** 交易时间起 */
    @ApiModelProperty(value = "交易时间起  时间格式为yyyy-MM-dd")
    private String rqsjStart;


    /** 交易时间止 */
    @ApiModelProperty(value = "交易时间止  时间格式为yyyy-MM-dd")
    private String rqsjEnd;

    /** 金额区间起 */
    @ApiModelProperty(value = "金额区间起  可为负数")
    private String jeStart;


    /** 金额区间止 */
    @ApiModelProperty(value = "金额区间止  可为负数")
    private String jeEnd;

    /** 门店编码 */
    @ApiModelProperty(value = "门店编码",required = true)
    private String storeCode;

    /**页码*/
    @ApiModelProperty(value = "页码",name = "pageNo")
    private Integer pageNo=1;

    /**页码*/
    @ApiModelProperty(value = "页容量",name = "pageSize")
    private Integer pageSize=10;


}
