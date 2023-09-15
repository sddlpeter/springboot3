package com.powernode.tran.service;

import com.powernode.tran.po.ArticlePO;

public interface ArticleService {
    boolean postNewArticle(ArticlePO article, String content);

    boolean manageArticle(ArticlePO po, String content);

    boolean postNewArticleThread(ArticlePO articlePO, String content);
}
