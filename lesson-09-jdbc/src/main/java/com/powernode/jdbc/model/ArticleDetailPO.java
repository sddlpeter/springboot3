package com.powernode.jdbc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDetailPO {
    Integer id;
    Integer articleId;
    String content;
}
