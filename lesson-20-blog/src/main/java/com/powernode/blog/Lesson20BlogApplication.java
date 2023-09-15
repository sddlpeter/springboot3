package com.powernode.blog;

import com.powernode.blog.settings.ArticleSettings;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableTransactionManagement
@MapperScan(basePackages = "com.powernode.blog.mapper")
@EnableConfigurationProperties({ArticleSettings.class})
@SpringBootApplication
public class Lesson20BlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lesson20BlogApplication.class, args);
	}

}
