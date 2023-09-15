package com.powernode.tran.service.impl;

import com.powernode.tran.mapper.ArticleMapper;
import com.powernode.tran.po.ArticleDetailPO;
import com.powernode.tran.po.ArticlePO;
import com.powernode.tran.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;


@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;


    // @Transactional(rollbackFor = {IOException.class})
    @Transactional
    @Override
    public boolean postNewArticle(ArticlePO article, String content) {
        int rows = articleMapper.insertArticle(article);

        if (article.getReadCount() < 1) {
            throw new RuntimeException("文章的阅读数量小于1");
        }

        ArticleDetailPO detail = new ArticleDetailPO();
        detail.setArticleId(article.getId());
        detail.setContent(content);
        int detailRows = articleMapper.insertDetail(detail);

        return (rows + detailRows) == 2 ? true : false;
    }

    @Override
    public boolean manageArticle(ArticlePO po, String content) {
        return postNewArticle(po, content);
    }


    @Transactional
    @Override
    public boolean postNewArticleThread(ArticlePO article, String content) {
        System.out.println("start 父线程" + Thread.currentThread().threadId());
        Thread thread = new Thread(() -> {
            System.out.println("子线程：" + Thread.currentThread().threadId());
            int rows = articleMapper.insertArticle(article);

            if (article.getReadCount() < 1) {
                throw new RuntimeException("=======文章的阅读数量小于1=======");
            }

            ArticleDetailPO detail = new ArticleDetailPO();
            detail.setArticleId(article.getId());
            detail.setContent(content);
            int detailRows = articleMapper.insertDetail(detail);
        });

        thread.start();
        try{
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("end 父线程" + Thread.currentThread().threadId());

        return true;
    }
}
