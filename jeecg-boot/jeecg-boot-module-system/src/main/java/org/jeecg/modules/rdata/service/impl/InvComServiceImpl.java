package org.jeecg.modules.rdata.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.rdata.entity.InvCom;
import org.jeecg.modules.rdata.mapper.InvComMapper;
import org.jeecg.modules.rdata.service.IInvComService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 小票明细表
 * @Author: jeecg-boot
 * @Date:   2021-04-23
 * @Version: V1.0
 */
@DS("multi-datasource1")
@Service
public class InvComServiceImpl extends ServiceImpl<InvComMapper, InvCom> implements IInvComService {

}
