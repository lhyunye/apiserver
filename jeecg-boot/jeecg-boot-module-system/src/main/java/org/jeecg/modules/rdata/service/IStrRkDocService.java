package org.jeecg.modules.rdata.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.jeecg.modules.rdata.entity.StrDdDoc;
import org.jeecg.modules.rdata.entity.StrRkDoc;
import org.jeecg.modules.rdata.vo.CheckResurt;
import org.jeecg.modules.rdata.vo.EsCheckResurt;
import org.jeecg.modules.rdata.vo.QueryDdDoc;
import org.jeecg.modules.rdata.vo.QueryRkDoc;

/**
 * @Description: 入库退厂单主表
 * @Author: jeecg-boot
 * @Date:   2021-04-22
 * @Version: V1.0
 */
public interface IStrRkDocService extends IService<StrRkDoc> {

    public CheckResurt checkAndput(QueryWrapper<StrRkDoc> queryWrapper, QueryRkDoc queryRkDoc, String copt);

    public EsCheckResurt checkAndput(BoolQueryBuilder query, QueryRkDoc queryRkDoc);


}
