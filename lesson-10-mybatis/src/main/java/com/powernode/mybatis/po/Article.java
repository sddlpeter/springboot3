package com.powernode.mybatis.po;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class Article {
    private Integer id;
    private Integer userId;
    private String title;
    private String summary;
    private Integer readCount;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    private ArticleDetail articleDetail;
}
