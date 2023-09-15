package com.powernode.quickweb.controller;

import com.powernode.quickweb.vo.ArticleVO;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ArticleController {

    @PostMapping("/article/add")
    public Map<String, Object> addArticle(@Validated(ArticleVO.AddArticleGroup.class) @RequestBody ArticleVO article, BindingResult br) {
        Map<String, Object> map = new HashMap<>();
        if (br.hasErrors()) {
            List<FieldError> fieldErrors = br.getFieldErrors();
            for (int i = 0, len = fieldErrors.size(); i < len; i++) {
                FieldError field = fieldErrors.get(i);
                map.put(i + "-" + field.getField(), field.getDefaultMessage());
            }
        }
        return map;
    }


    @PostMapping("/article/edit")
    public Map<String, Object> editArticle(@Validated(ArticleVO.EditArticleGroup.class) @RequestBody ArticleVO article, BindingResult br) {
        Map<String, Object> map = new HashMap<>();
        if (br.hasErrors()) {
            List<FieldError> fieldErrors = br.getFieldErrors();
            for (int i = 0, len = fieldErrors.size(); i < len; i++) {
                FieldError field = fieldErrors.get(i);
                map.put(i + "-" + field.getField(), field.getDefaultMessage());
            }
        }
        return map;
    }
}
