package com.numerx.formweb.heroform.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.numerx.formweb.heroform.entity.Hero;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper Interface
 * </p>
 *
 * @author matrixorz
 * @since 2019-08-14
 */
public interface HeroMapper extends BaseMapper<Hero> {

    List<Map<Object, Object>> selectMap(Page<Map<Object, Object>> mapPage);
}
