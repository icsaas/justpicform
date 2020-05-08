package com.numerx.formweb.heroform.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.numerx.formweb.heroform.entity.Hero;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;
/**
 * <p>
 *  servcie class
 * </p>
 *
 * @author matrixorz
 * @since 2019-08-14
 */
public interface IHeroService extends IService<Hero> {

    Page<Map<Object, Object>> selectHeroPage(Page<Map<Object, Object>> mapPage);
}
