package com.powernode.pk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class Lesson06PackageApplication {

    @Bean
    public Date myDate() {
        return new Date();
    }

    public static void main(String[] args) {
        ApplicationContext app =  SpringApplication.run(Lesson06PackageApplication.class, args);
        Date bean = app.getBean(Date.class);

    }

}
