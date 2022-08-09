package org.jeecg.modules.demonstration.service;

import org.jeecg.modules.demonstration.entity.TestDev;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.common.exception.JeecgBootException;

/**
 * @Description: 测试表生成
 * @Author: jeecg-boot
 * @Date:   2021-07-27
 * @Version: V1.0
 */
public interface ITestDevService extends IService<TestDev> {

	/**根节点父ID的值*/
	public static final String ROOT_PID_VALUE = "0";
	
	/**树节点有子节点状态值*/
	public static final String HASCHILD = "1";
	
	/**树节点无子节点状态值*/
	public static final String NOCHILD = "0";

	/**新增节点*/
	void addTestDev(TestDev testDev);
	
	/**修改节点*/
	void updateTestDev(TestDev testDev) throws JeecgBootException;
	
	/**删除节点*/
	void deleteTestDev(String id) throws JeecgBootException;

}
