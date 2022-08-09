package org.jeecg.modules.rdata.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jeecg.modules.rdata.entity.StrDdCom;
import org.jeecg.modules.rdata.entity.StrDdDoc;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="str_dd_doc_model", description="订单详情查询")
public class StrDdDocModel {

    /** 订单详情 */
    @ApiModelProperty(value = "订单详情")
    private StrDdDoc strDdDoc;


    /** 订单详情 */
    @ApiModelProperty(value = "订单明细列表")
    private List<StrDdCom> strDdComs;
}
