package com.numerx.formboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author matrixorz
 * @data 2019-08-13 23:16
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket newsApi(){
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        docket.enable(true);

        docket.apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.danni.web.controller"))
                .paths(PathSelectors.any()).build();
        return docket;
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("numerx的项目").description("在这里你可以浏览项目所有接口，并提供相关测试工具")
                .termsOfServiceUrl("http://baidu.com").contact("test")
                .license("MIT").license("#").version("1.0").build();
    }
}
