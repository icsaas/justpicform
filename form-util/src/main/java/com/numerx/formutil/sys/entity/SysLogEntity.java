

package com.numerx.formutil.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

import java.io.Serializable;
import java.util.Date;


/**
 * 系统日志
 */
@TableName("sys_log")
@Table(name="sys_log")
public class SysLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@TableId
	@Column(name="id",type= MySqlTypeConstant.BIGINT,length = 111,isKey = true,isAutoIncrement = true)
	private Long id;
	//用户名
	@Column(name="username",type= MySqlTypeConstant.VARCHAR,length=111)
	private String username;
	//用户操作
	@Column(name="operation",type= MySqlTypeConstant.VARCHAR,length=111)
	private String operation;
	//请求方法
	@Column(name="method",type= MySqlTypeConstant.VARCHAR,length=111)
	private String method;
	//请求参数
	@Column(name="params",type= MySqlTypeConstant.VARCHAR,length=111)
	private String params;
	//执行时长(毫秒)
	@Column(name="time",type= MySqlTypeConstant.BIGINT,length=111)
	private Long time;
	//IP地址
	@Column(name="ip",type= MySqlTypeConstant.VARCHAR,length=111)
	private String ip;
	//创建时间
	@Column(name="createDate",type= MySqlTypeConstant.DATE)
	private Date createDate;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
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
	 * 设置：用户操作
	 */
	public void setOperation(String operation) {
		this.operation = operation;
	}
	/**
	 * 获取：用户操作
	 */
	public String getOperation() {
		return operation;
	}
	/**
	 * 设置：请求方法
	 */
	public void setMethod(String method) {
		this.method = method;
	}
	/**
	 * 获取：请求方法
	 */
	public String getMethod() {
		return method;
	}
	/**
	 * 设置：请求参数
	 */
	public void setParams(String params) {
		this.params = params;
	}
	/**
	 * 获取：请求参数
	 */
	public String getParams() {
		return params;
	}
	/**
	 * 设置：IP地址
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	/**
	 * 获取：IP地址
	 */
	public String getIp() {
		return ip;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateDate() {
		return createDate;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}
}
