package com.numerx.formweb.trial.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.numerx.formweb.trial.model.Test;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("testMapper")
public interface TestMapper  extends BaseMapper<Test> {
    public int findTestCount();
}
