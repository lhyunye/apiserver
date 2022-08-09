package org.jeecg.modules.rdata.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="rk_comvo", description="入库退厂单金额")
public class RkComvo {

    /** 订单号 */
    @ApiModelProperty(value = "订单号")
    private String seqno;

    /** 含税售价金额 */
    @ApiModelProperty(value = "含税售价金额")
    private BigDecimal hsjjje;

    /** 不含税售价金额 */
    @ApiModelProperty(value = "不含税售价金额")
    private BigDecimal bhsjjje;

    /** 税额 */
    @ApiModelProperty(value = "税额")
    private BigDecimal se;


}
