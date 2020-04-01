
package com.numerx.formutil.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.command.BaseModel;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

import java.io.Serializable;
import java.util.Date;


@TableName("sys_captcha")
@Table(name="sys_captcha")
public class SysCaptchaEntity  extends BaseModel implements Serializable {
    private static final long serialVersionUID = 5199200306752426432L;

    @TableId(type = IdType.INPUT)
    @Column(name="uuid",type= MySqlTypeConstant.VARCHAR,length = 111,isKey = true)
    private String uuid;
    /**
     * 验证码
     */
    @Column(name="name",type=MySqlTypeConstant.VARCHAR,length=111)
    private String code;
    /**
     * 过期时间
     */
    @Column(name="expireTime",type=MySqlTypeConstant.DATE)
    private Date expireTime;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }
}
