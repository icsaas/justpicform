

package com.numerx.formutil.app.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

import java.io.Serializable;
import java.util.Date;


/**
 * 用户
 */
@TableName("tb_user")
@Table(name="tb_user")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
	@TableId
	@Column(name="userId",type= MySqlTypeConstant.INT,length = 11,isKey = true,isAutoIncrement = true)
	private Long userId;
	/**
	 * 用户名
	 */
	@Column(name="username",type=MySqlTypeConstant.VARCHAR,length=111)
	private String username;
	/**
	 * 手机号
	 */
	@Column(name="mobile",type=MySqlTypeConstant.VARCHAR,length=111)
	private String mobile;
	/**
	 * 密码
	 */
	@Column(name="password",type=MySqlTypeConstant.VARCHAR,length=111)
	private String password;
	/**
	 * 创建时间
	 */
	@Column(name="createTime",type=MySqlTypeConstant.DATE)
	private Date createTime;

	/**
	 * 设置：用户ID
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户ID
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：用户名
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：手机号
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：手机号
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置：密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
}
