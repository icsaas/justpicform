package com.numerx.formweb.trial.manager.impl;

import com.numerx.formweb.trial.manager.TestManager;
import com.numerx.formweb.trial.mapper.TestMapper;
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

    @Override
    public int findTestCount(){
        return testMapper.findTestCount();
    }
}
