package com.powernode.mybatis.po;

import lombok.Data;

@Data
public class CommentPO {
    private Integer id;
    private Integer articleId;
    private String content;
}
