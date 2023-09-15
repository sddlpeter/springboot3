package com.powernode.config;

import com.powernode.config.pk10.Person;
import com.powernode.config.pk6.NestAppBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

@ImportResource(locations = {"classpath:/applicationContext.xml"})

// @EnableConfigurationProperties(NestAppBean.class)
@ConfigurationPropertiesScan(basePackages = {"com.powernode.config.pk6", "com.powernode.config.pk8"})
@SpringBootApplication
public class Lesson07 {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Lesson07.class, args);
        Person bean = run.getBean(Person.class);
        System.out.println(bean);
    }

}