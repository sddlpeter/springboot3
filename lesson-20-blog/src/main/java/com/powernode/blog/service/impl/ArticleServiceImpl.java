package com.powernode.blog.service.impl;

import com.powernode.blog.mapper.ArticleMapper;
import com.powernode.blog.model.dto.ArticleDTO;
import com.powernode.blog.model.map.ArticleAndDetailMap;
import com.powernode.blog.model.po.ArticleDetailPO;
import com.powernode.blog.model.po.ArticlePO;
import com.powernode.blog.service.ArticleService;
import com.powernode.blog.settings.ArticleSettings;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleMapper articleMapper;
    private final ArticleSettings articleSettings;

/*    public ArticleServiceImpl(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }*/

    @Override
    public List<ArticlePO> queryTopArticle() {
        Integer lowRead = articleSettings.getLowRead();
        Integer topRead = articleSettings.getTopRead();

        List<ArticlePO> articleList = articleMapper.topSortByReadCount(lowRead, topRead);
        return articleList;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addArticle(ArticleDTO articleDTO) {
        // 文章
        ArticlePO articlePO = new ArticlePO();
        articlePO.setTitle(articleDTO.getTitle());
        articlePO.setSummary(articleDTO.getSummary());
        articlePO.setCreateTime(LocalDateTime.now());
        articlePO.setUpdateTime(LocalDateTime.now());
        articlePO.setReadCount(new Random().nextInt(200));
        articlePO.setUserId(new Random().nextInt(5000));

        int addArticle = articleMapper.insertArticle(articlePO);

        // 文章内容
        ArticleDetailPO articleDetailPO = new ArticleDetailPO();
        articleDetailPO.setArticleId(articlePO.getId());
        articleDetailPO.setContent(articleDTO.getContent());
        int addDetail = articleMapper.insertArticleDetail(articleDetailPO);


        return addArticle + addDetail == 2 ? true : false;
    }



    @Override
    public ArticleDTO queryByArticleId(Integer id) {
        ArticleAndDetailMap mapper = articleMapper.selectArticleAndDetail(id);
        //转为dto
        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setTitle(mapper.getTitle());
        articleDTO.setContent(mapper.getContent());
        articleDTO.setSummary(mapper.getSummary());
        articleDTO.setId(mapper.getId());
        return articleDTO;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean modifyArticle(ArticleDTO articleDTO) {
        // 修改文章属性

        ArticlePO articlePO = new ArticlePO();
        articlePO.setId(articleDTO.getId());
        articlePO.setTitle(articleDTO.getTitle());
        articlePO.setSummary(articleDTO.getSummary());
        articlePO.setUpdateTime(LocalDateTime.now());
        int article = articleMapper.updateArticle(articlePO);

        // 修改文章内容
        ArticleDetailPO articleDetailPO = new ArticleDetailPO();
        articleDetailPO.setArticleId(articleDTO.getId());
        articleDetailPO.setContent(articleDTO.getContent());
        int detail = articleMapper.updateArticleDetail(articleDetailPO);

        return article + detail == 2 ? true : false;
    }

    // 删除文章的属性，和内容
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean removeArticle(List<Integer> idList) {
        int article = articleMapper.deleteArticle(idList);
        int detail = articleMapper.deleteDetail(idList);

        return article + detail == 2 ? true : false;
    }

    @Override
    public String queryTop20Content(Integer id) {
        ArticleDetailPO articleDetailPO = articleMapper.selectArticleDetailByArticleId(id);
        String content = "无内容";
        if (articleDetailPO!=null) {
            content = articleDetailPO.getContent();
            if (StringUtils.hasText(content)) {
                content = content.substring(0, content.length() >= 20 ? 20 : content.length());
            }
        }
        return content;
    }
}
