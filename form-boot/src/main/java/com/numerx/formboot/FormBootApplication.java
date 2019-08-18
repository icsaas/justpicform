package com.numerx.formboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.numerx.formboot.*"})
public class FormBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(FormBootApplication.class, args);
    }

}
