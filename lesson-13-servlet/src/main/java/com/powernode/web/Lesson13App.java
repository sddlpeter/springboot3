package com.powernode.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

// 扫描@WebServlet注解
@ServletComponentScan(basePackages = "com.powernode.web")
@SpringBootApplication
public class Lesson13App {
    public static void main(String[] args) {
        SpringApplication.run(Lesson13App.class, args);
    }

}
