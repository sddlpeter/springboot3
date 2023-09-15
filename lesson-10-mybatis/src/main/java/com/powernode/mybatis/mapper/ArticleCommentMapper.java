package com.powernode.mybatis.mapper;

import com.powernode.mybatis.po.ArticleEntity;
import com.powernode.mybatis.po.CommentPO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface ArticleCommentMapper {

    @Select("""
            select id,article_id,content from comment where article_id=#{articleId}
            order by id
            """)
    @Results(id="CommentMapper", value={
            @Result(id=true, column = "id", property = "id"),
            @Result(column = "article_id", property = "articleId"),
            @Result(column = "content", property = "content")
    })
    List<CommentPO> selectComments(Integer articleId);

    @Select("""
            select id,user_id, title,summary,read_count,create_time,update_time 
            from article where id = #{articleId}
            """)
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "title", property = "title"),
            @Result(column = "summary", property = "summary"),
            @Result(column = "read_count", property = "readCount"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime"),
            @Result(column = "id", property = "comments",
            many=@Many(select = "com.powernode.mybatis.mapper.ArticleCommentMapper.selectComments", fetchType = FetchType.LAZY))
    })
    ArticleEntity selectArticleComment(Integer id);
}
