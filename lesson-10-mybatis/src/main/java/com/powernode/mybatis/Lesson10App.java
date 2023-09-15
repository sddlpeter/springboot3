package com.powernode.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.powernode.mybatis.mapper")
@SpringBootApplication
public class Lesson10App {

    public static void main(String[] args) {
        SpringApplication.run(Lesson10App.class, args);
    }

}
