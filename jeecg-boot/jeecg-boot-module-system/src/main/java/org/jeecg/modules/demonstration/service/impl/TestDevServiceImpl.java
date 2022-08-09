package org.jeecg.modules.demonstration.service.impl;

import org.jeecg.common.exception.JeecgBootException;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.demonstration.entity.TestDev;
import org.jeecg.modules.demonstration.mapper.TestDevMapper;
import org.jeecg.modules.demonstration.service.ITestDevService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 测试表生成
 * @Author: jeecg-boot
 * @Date:   2021-07-27
 * @Version: V1.0
 */
@Service
public class TestDevServiceImpl extends ServiceImpl<TestDevMapper, TestDev> implements ITestDevService {

	@Override
	public void addTestDev(TestDev testDev) {
		if(oConvertUtils.isEmpty(testDev.getPid())){
			testDev.setPid(ITestDevService.ROOT_PID_VALUE);
		}else{
			//如果当前节点父ID不为空 则设置父节点的hasChildren 为1
			TestDev parent = baseMapper.selectById(testDev.getPid());
			if(parent!=null && !"1".equals(parent.getHasChild())){
				parent.setHasChild("1");
				baseMapper.updateById(parent);
			}
		}
		baseMapper.insert(testDev);
	}
	
	@Override
	public void updateTestDev(TestDev testDev) {
		TestDev entity = this.getById(testDev.getId());
		if(entity==null) {
			throw new JeecgBootException("未找到对应实体");
		}
		String old_pid = entity.getPid();
		String new_pid = testDev.getPid();
		if(!old_pid.equals(new_pid)) {
			updateOldParentNode(old_pid);
			if(oConvertUtils.isEmpty(new_pid)){
				testDev.setPid(ITestDevService.ROOT_PID_VALUE);
			}
			if(!ITestDevService.ROOT_PID_VALUE.equals(testDev.getPid())) {
				baseMapper.updateTreeNodeStatus(testDev.getPid(), ITestDevService.HASCHILD);
			}
		}
		baseMapper.updateById(testDev);
	}
	
	@Override
	public void deleteTestDev(String id) throws JeecgBootException {
		TestDev testDev = this.getById(id);
		if(testDev==null) {
			throw new JeecgBootException("未找到对应实体");
		}
		updateOldParentNode(testDev.getPid());
		baseMapper.deleteById(id);
	}
	
	
	
	/**
	 * 根据所传pid查询旧的父级节点的子节点并修改相应状态值
	 * @param pid
	 */
	private void updateOldParentNode(String pid) {
		if(!ITestDevService.ROOT_PID_VALUE.equals(pid)) {
			Integer count = baseMapper.selectCount(new QueryWrapper<TestDev>().eq("pid", pid));
			if(count==null || count<=1) {
				baseMapper.updateTreeNodeStatus(pid, ITestDevService.NOCHILD);
			}
		}
	}

}
