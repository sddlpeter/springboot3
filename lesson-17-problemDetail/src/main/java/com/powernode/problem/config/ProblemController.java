package com.powernode.problem.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProblemController {

    @GetMapping("/probs/not-found")
    public String doNotFound() {
        return "图书的isbn不存在...";
    }
}
