package com.powernode.tran;

import com.powernode.tran.po.ArticlePO;
import com.powernode.tran.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Random;

@SpringBootTest
class lesson11Test {

    @Autowired
    ArticleService articleService;

    @Test
    void testInsertArticle() {
        ArticlePO articlePO = new ArticlePO();
        articlePO.setUpdateTime(LocalDateTime.now());
        articlePO.setCreateTime(LocalDateTime.now());
        articlePO.setTitle("Spring的事务管理");
        articlePO.setSummary("基于spring的注解式事务管理，进行事务控制");
        articlePO.setUserId(new Random().nextInt(500));
        articlePO.setReadCount(new Random().nextInt(1000));

        String content = "基于spring的注解式事务管理，进行事务控制：1 声明式， 2 编程式";
        boolean add = articleService.postNewArticle(articlePO, content);
        System.out.println("发布新文章= "+add);
    }


    @Test
    void testInsertArticleTrans() {
        ArticlePO articlePO = new ArticlePO();
        articlePO.setUpdateTime(LocalDateTime.now());
        articlePO.setCreateTime(LocalDateTime.now());
        articlePO.setTitle("Spring的事务管理11");
        articlePO.setSummary("基于spring的注解式事务管理，进行事务控制");
        articlePO.setUserId(new Random().nextInt(500));
        articlePO.setReadCount(0);

        String content = "1111基于spring的注解式事务管理，进行事务控制：1 声明式， 2 编程式";
        boolean add = articleService.postNewArticle(articlePO, content);
        System.out.println("发布新文章= "+add);
    }

    @Test
    void testManagerArticleTrans() {
        ArticlePO articlePO = new ArticlePO();
        articlePO.setUpdateTime(LocalDateTime.now());
        articlePO.setCreateTime(LocalDateTime.now());
        articlePO.setTitle("============SpringMVC开发应用程序");
        articlePO.setSummary("==========基于springMVC架构的");
        articlePO.setUserId(new Random().nextInt(500));
        articlePO.setReadCount(0);

        String content = "===============Web开发使用MVC架构";
        boolean add = articleService.manageArticle(articlePO, content);
        System.out.println("发布新文章= "+add);
    }


    @Test
    void testManagerArticleTransThread() {
        ArticlePO articlePO = new ArticlePO();
        articlePO.setUpdateTime(LocalDateTime.now());
        articlePO.setCreateTime(LocalDateTime.now());
        articlePO.setTitle("============SpringMVC开发应用程序============");
        articlePO.setSummary("==========基于springMVC架构的============");
        articlePO.setUserId(new Random().nextInt(500));
        articlePO.setReadCount(0);

        String content = "===============Web开发使用MVC架构============";
        boolean add = articleService.postNewArticleThread(articlePO, content);
        System.out.println("发布新文章= "+add);
    }

}
