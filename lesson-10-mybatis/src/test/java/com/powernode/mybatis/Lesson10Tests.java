package com.powernode.mybatis;

import com.powernode.mybatis.mapper.ArticleMapper;
import com.powernode.mybatis.po.ArticlePO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Random;

@SpringBootTest
class Lesson10Tests {

    @Autowired
    ArticleMapper articleMapper;

    @Test
    void test01() {
        ArticlePO articlePO = articleMapper.selectById(1);
        System.out.println(articlePO);
    }

    @Test
    void test02() {
        ArticlePO articlePO = new ArticlePO();
        articlePO.setTitle("");
        articlePO.setSummary("use tomcat server, customize web app");
        articlePO.setReadCount(19);
        articlePO.setUserId(new Random().nextInt(500));
        articlePO.setCreateTime(LocalDateTime.now());
        articlePO.setUpdateTime(LocalDateTime.now());

        int rows = articleMapper.insertArticle(articlePO);

    }

    @Test
    void test03() {
        articleMapper.updateReadCount(3, 190);
    }

    @Test
    void test04() {
        articleMapper.deleteById(3);
    }



}
