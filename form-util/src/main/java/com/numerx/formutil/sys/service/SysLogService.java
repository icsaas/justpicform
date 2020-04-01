
package com.numerx.formutil.sys.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.numerx.formutil.sys.entity.SysLogEntity;
import com.numerx.formutil.utils.PageUtils;

import java.util.Map;


/**
 * 系统日志
 */
public interface SysLogService extends IService<SysLogEntity> {

    PageUtils queryPage(Map<String, Object> params);

}
