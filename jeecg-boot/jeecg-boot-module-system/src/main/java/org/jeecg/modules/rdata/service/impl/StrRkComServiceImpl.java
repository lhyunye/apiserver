package org.jeecg.modules.rdata.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.rdata.entity.StrRkCom;
import org.jeecg.modules.rdata.mapper.StrRkComMapper;
import org.jeecg.modules.rdata.service.IStrRkComService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 入库退厂单明细
 * @Author: jeecg-boot
 * @Date:   2021-04-22
 * @Version: V1.0
 */
@Service
@DS("multi-datasource1")
public class StrRkComServiceImpl extends ServiceImpl<StrRkComMapper, StrRkCom> implements IStrRkComService {

}
