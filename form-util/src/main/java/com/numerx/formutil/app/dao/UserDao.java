

package com.numerx.formutil.app.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.numerx.formutil.app.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-23 15:22:06
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {

}
