package com.numerx.formutil.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.numerx.formutil.sys.entity.SysRoleEntity;
import com.numerx.formutil.utils.PageUtils;

import java.util.List;
import java.util.Map;


/**
 * 角色
 */
public interface SysRoleService extends IService<SysRoleEntity> {

	PageUtils queryPage(Map<String, Object> params);

	boolean save(SysRoleEntity role);

	void update(SysRoleEntity role);

	void deleteBatch(Long[] roleIds);

	
	/**
	 * 查询用户创建的角色ID列表
	 */
	List<Long> queryRoleIdList(Long createUserId);
}
