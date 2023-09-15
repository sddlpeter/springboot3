package com.powernode.mybatis;

import com.powernode.mybatis.mapper.ArticleRepository;
import com.powernode.mybatis.po.ArticlePO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class RepositoryTest {

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    void name() {
        ArticlePO articlePO = articleRepository.selectByPrimary(2);
        System.out.println(articlePO);
    }


    @Test
    void testUpdate() {
        articleRepository.updateTime(2, LocalDateTime.now());
    }

    @Test
    void testInsert() {
        ArticlePO po = new ArticlePO();
        po.setTitle("springBoot3");
        po.setSummary("spring Boot 3 new course");
        po.setUserId(20);
        po.setReadCount(0);
        po.setCreateTime(LocalDateTime.now());
        po.setUpdateTime(LocalDateTime.now());
        articleRepository.insertArticle(po);
    }

    @Test
    void testDelete() {
        articleRepository.deleteById(4);
    }

}
