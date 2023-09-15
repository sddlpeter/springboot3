package com.powernode.tran;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@MapperScan(basePackages = "com.powernode.tran.mapper")
@SpringBootApplication
public class Lesson11App {

    public static void main(String[] args) {
        SpringApplication.run(Lesson11App.class, args);
    }

}
