package com.numerx.formboot;

import net.hasor.spring.boot.EnableHasor;
import net.hasor.spring.boot.EnableHasorWeb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableHasor()
@EnableHasorWeb()
@SpringBootApplication
@ComponentScan(basePackages = {"com.numerx.formboot.*"})
public class FormBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(FormBootApplication.class, args);
    }

}
