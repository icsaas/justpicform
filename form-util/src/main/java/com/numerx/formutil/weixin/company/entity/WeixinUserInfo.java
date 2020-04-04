package com.numerx.formutil.weixin.company.entity;


/**
 * 用户基本信息
 */

public class WeixinUserInfo {
	// 员工Userid。对应管理端的帐号，企业内必须唯一。长度为1~64个字符
	private String userid;
	// 成员名称
	private String name;
	//成员所属部门id列表
	private Object department;
	//职位信息
	private String position;
	//手机
	private String mobile;
	// 性别。gender=0表示男，=1表示女。默认gender=0
	private int gender;
	// 办公电话
	private String tel;
	// 邮箱
	private String email;
	// 微信号
	private String weixinid;
	// 扩展属性
	private String extattr;
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Object getDepartment() {
		return department;
	}
	public void setDepartment(Object department) {
		this.department = department;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWeixinid() {
		return weixinid;
	}
	public void setWeixinid(String weixinid) {
		this.weixinid = weixinid;
	}
	public String getExtattr() {
		return extattr;
	}
	public void setExtattr(String extattr) {
		this.extattr = extattr;
	}

	
}
