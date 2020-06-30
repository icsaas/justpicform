package com.numerx.formboot.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
@MapperScan("com.numerx.formboot.**.mapper")
public class MybatisPlusConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor(){
     PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
    //设置请求的页面大于最大页后操作，true调回到首页，false继续请求 默认false
    //paginationInterceptor.setOverflow(false);
    //设置最大单页限制数量，默认500条，-1不受限制
    //paginationInterceptor.setLimit(500);
    //开启count的join优化，只针对部分leftjoin
    paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
    return paginationInterceptor;
    }
}
