package com.powernode.blog.service;

import com.powernode.blog.model.dto.ArticleDTO;
import com.powernode.blog.model.po.ArticlePO;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface ArticleService {

    List<ArticlePO> queryTopArticle();

    // 发布文章 article, article_detail
    boolean addArticle(ArticleDTO articleDTO);

    // 根据主键查询文章
    ArticleDTO queryByArticleId(Integer id);


    // 修改文章
    boolean modifyArticle(ArticleDTO articleDTO);

    // 删除文章
    boolean removeArticle(List<Integer> idList);


    // 查询文章内容
    String queryTop20Content(Integer id);
}
