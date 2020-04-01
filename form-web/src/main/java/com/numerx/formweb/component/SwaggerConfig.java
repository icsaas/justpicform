package com.numerx.formweb.component;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@EnableSwagger2
@Configuration
@EnableWebMvc
public class SwaggerConfig {

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				//.apis(RequestHandlerSelectors.basePackage("com.vacomall.controller"))
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("restful-api,Restfull接口生成框架")
				.termsOfServiceUrl("http://www.justpic.org/")
				.description("springmvc + swagger2 Restfull接口生成框架")
				.contact(new Contact("matrixorz", "http://www.justpic.org/", "i@justpic.org"))
				.version("1.0.0")
				.build();
	}
}
