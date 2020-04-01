package com.numerx.formutil.app.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.numerx.formutil.app.dao.UserDao;
import com.numerx.formutil.app.entity.UserEntity;
import com.numerx.formutil.app.form.LoginForm;
import com.numerx.formutil.app.service.UserService;
import com.numerx.formutil.exception.RRException;
import com.numerx.formutil.validator.Assert;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

	@Override
	public UserEntity queryByMobile(String mobile) {
		QueryWrapper<UserEntity> userEntity = new QueryWrapper<UserEntity>();
		UserEntity userEntity1=new UserEntity() ;
		userEntity1.setMobile(mobile);
		userEntity.setEntity(userEntity1);
		return (UserEntity) baseMapper.selectOne(userEntity);
	}

	@Override
	public long login(LoginForm form) {
		UserEntity user = queryByMobile(form.getMobile());
		Assert.isNull(user, "手机号或密码错误");

		//密码错误
		if(!user.getPassword().equals(DigestUtils.sha256Hex(form.getPassword()))){
			throw new RRException("手机号或密码错误");
		}

		return user.getUserId();
	}
}
