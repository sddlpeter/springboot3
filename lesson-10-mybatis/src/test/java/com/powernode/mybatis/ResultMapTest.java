package com.powernode.mybatis;

import com.powernode.mybatis.mapper.ArticleDao;
import com.powernode.mybatis.po.ArticlePO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ResultMapTest {
    @Autowired
    private ArticleDao articleDao;

    @Test
    void test01() {
        ArticlePO articlePO = articleDao.selectById(2);
        System.out.println(articlePO);
    }

    @Test
    void test02() {
        List<ArticlePO> articlePOS = articleDao.selectList(2101);
        articlePOS.forEach(a -> {
            System.out.println(a);
        });
    }
}
