package com.numerx.formweb.manager.impl;

import com.numerx.formweb.manager.TestManager;
import com.numerx.formweb.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author matrixorz
 * @data 2019-08-12 01:40
 */
@Transactional
@Service("testManager")
public class TestManagerImpl implements TestManager {
    @Autowired
    private TestMapper testMapper;

    public int findTestCount(){
        return testMapper.findTestCount();
    }
}
