package org.jeecg.modules.rdata.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jeecg.modules.rdata.entity.StrDdCom;
import org.jeecg.modules.rdata.entity.StrDdDoc;
import org.jeecg.modules.rdata.entity.StrRkCom;
import org.jeecg.modules.rdata.entity.StrRkDoc;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="str_rk_doc_model", description="入库退厂单详情查询")
public class StrRkDocModel {

    /** 入库退厂单详情 */
    @ApiModelProperty(value = "入库退厂单详情")
    private StrRkDoc strRkDoc;


    /** 入库退厂单明细列表 */
    @ApiModelProperty(value = "入库退厂单明细列表")
    private List<StrRkCom> strRkComs;
}
