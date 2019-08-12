package com.numerx.formboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.numerx.formboot.mapper.*")
@SpringBootApplication
public class FormBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(FormBootApplication.class, args);
    }

}
