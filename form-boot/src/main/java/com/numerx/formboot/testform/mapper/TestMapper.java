package com.numerx.formboot.testform.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.numerx.formboot.testform.entity.Test;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author matrixorz
 * @since 2019-08-13
 */
public interface TestMapper extends BaseMapper<Test> {

    List<Map<Object, Object>> selectMap(Page<Map<Object, Object>> page);
}
