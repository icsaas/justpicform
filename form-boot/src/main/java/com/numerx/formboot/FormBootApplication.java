package com.numerx.formboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath*:/applicationContext-service.xml")
@SpringBootApplication
@MapperScan("com.numerx.formboot.**.mapper")
@ComponentScan(basePackages = {"com.numerx"})
public class FormBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(FormBootApplication.class, args);
    }

}
