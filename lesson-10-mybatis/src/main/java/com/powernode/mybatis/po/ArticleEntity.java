package com.powernode.mybatis.po;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ArticleEntity {
    private Integer id;
    private Integer userId;
    private String title;
    private String summary;
    private Integer readCount;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    List<CommentPO> comments;
}
