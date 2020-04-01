

package com.numerx.formutil.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

import javax.validation.constraints.NotBlank;

/**
 * 系统配置信息
 */
@TableName("sys_config")
@Table(name="sys_config")
public class SysConfigEntity {
	@TableId
	@Column(name="id",type= MySqlTypeConstant.INT,length = 11,isKey = true,isAutoIncrement = true)
	private Long id;
	@NotBlank(message="参数名不能为空")

	@Column(name="paramKey",type=MySqlTypeConstant.VARCHAR,length=111)
	private String paramKey;

	@NotBlank(message="参数值不能为空")
	@Column(name="paramValue",type=MySqlTypeConstant.VARCHAR,length=111)
	private String paramValue;

	@Column(name="remark",type=MySqlTypeConstant.VARCHAR,length=111)
	private String remark;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getParamKey() {
		return paramKey;
	}

	public void setParamKey(String paramKey) {
		this.paramKey = paramKey;
	}

	public String getParamValue() {
		return paramValue;
	}

	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}

	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
