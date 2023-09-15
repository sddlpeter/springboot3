package com.powernode.mvc.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {

    @PostMapping("/article/add")
    public String addArticle() {
        return "发布新文章";
    }

    @PostMapping("/article/edit")
    public String editArticle() {
        return "修改文章";
    }

    @GetMapping("/article/query")
    public String query() {
        return "查询文章";
    }

    @DeleteMapping("/article/remove")
    public String remove() {
        return "删除文章";
    }
}
