package com.powernode.quickweb.vo;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ArticleVO {

    // 分组接口名
    public static interface AddArticleGroup {}

    public static interface EditArticleGroup{}

    @NotNull(message = "文章id必须有值",groups={EditArticleGroup.class})
    @Min(value = 1, message = "id大于0", groups = {EditArticleGroup.class})
    private Integer id;

    @NotNull(message = "必须由作者", groups = {AddArticleGroup.class, EditArticleGroup.class})
    private Integer userId;

    @NotBlank(message = "文章必须由标题", groups = {AddArticleGroup.class, EditArticleGroup.class})
    @Size(min=3, max = 30, message = "标题在3个字符以上")
    private String title;

    @NotBlank(message = "必须由副标题", groups = {AddArticleGroup.class, EditArticleGroup.class})
    @Size(min = 5, max = 60, message = "副标题必须5个字以上")
    private String summary;

    @DecimalMin(value = "0", message = "阅读数量不能小于0", groups = {AddArticleGroup.class, EditArticleGroup.class})
    private Integer readCount;

    @Email(message = "邮箱不符合规则", groups = {AddArticleGroup.class, EditArticleGroup.class})
    private String email;
}
