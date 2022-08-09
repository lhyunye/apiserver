package org.jeecg.modules.rdata.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.jeecg.modules.rdata.entity.InvMain;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.rdata.entity.StrDdDoc;
import org.jeecg.modules.rdata.vo.CheckResurt;
import org.jeecg.modules.rdata.vo.EsCheckResurt;
import org.jeecg.modules.rdata.vo.QueryDdDoc;
import org.jeecg.modules.rdata.vo.QueryInvMain;

/**
 * @Description: 小票主单表
 * @Author: jeecg-boot
 * @Date:   2021-04-23
 * @Version: V1.0
 */
public interface IInvMainService extends IService<InvMain> {

    public CheckResurt checkAndput(QueryWrapper<InvMain> queryWrapper, QueryInvMain queryInvMain, String copt);

    public EsCheckResurt checkAndput(BoolQueryBuilder query, QueryInvMain queryInvMain);

}
