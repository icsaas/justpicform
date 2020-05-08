package com.numerx.formweb.heroform.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.numerx.formweb.heroform.entity.Hero;
import com.numerx.formweb.heroform.mapper.HeroMapper;
import com.numerx.formweb.heroform.service.IHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * <p>
 *  service implement class
 * </p>
 *
 * @author matrixorz
 * @since 2019-08-14
 */
@Service
public class HeroServiceImpl extends ServiceImpl<HeroMapper, Hero> implements IHeroService {
    @Autowired
    private HeroMapper heroMapper;

    @Override
    public Page<Map<Object, Object>> selectHeroPage(Page<Map<Object, Object>> mapPage){
        List<Map<Object, Object>> list = heroMapper.selectMap(mapPage);
        mapPage.setRecords(list);
        return mapPage;
    }
}
