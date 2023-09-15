package com.powernode.problem;

import com.powernode.problem.config.BookContainer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@EnableConfigurationProperties({BookContainer.class})
@SpringBootApplication
public class Lesson17ProblemDetailApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lesson17ProblemDetailApplication.class, args);
    }

}
