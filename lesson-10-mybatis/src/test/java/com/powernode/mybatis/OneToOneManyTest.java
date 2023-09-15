package com.powernode.mybatis;

import com.powernode.mybatis.mapper.ArticleCommentMapper;
import com.powernode.mybatis.mapper.ArticleOneToOneMapper;
import com.powernode.mybatis.po.Article;
import com.powernode.mybatis.po.ArticleEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OneToOneManyTest {

    @Autowired
    ArticleOneToOneMapper articleOneToOneMapper;

    @Test
    public void oneToOneTest() {
        Article article = articleOneToOneMapper.selectAllArticle(1);
        System.out.println(article);
    }

    @Autowired
    ArticleCommentMapper articleCommentMapper;

    @Test
    public void oneToManyTest() {
        ArticleEntity articleEntity = articleCommentMapper.selectArticleComment(1);
        System.out.println(articleEntity);
    }
}
