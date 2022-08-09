package org.jeecg.modules.demonstration.mapper;

import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.demonstration.entity.TestDev;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Description: 测试表生成
 * @Author: jeecg-boot
 * @Date:   2021-07-27
 * @Version: V1.0
 */
public interface TestDevMapper extends BaseMapper<TestDev> {

	/**
	 * 编辑节点状态
	 * @param id
	 * @param status
	 */
	void updateTreeNodeStatus(@Param("id") String id,@Param("status") String status);

}
