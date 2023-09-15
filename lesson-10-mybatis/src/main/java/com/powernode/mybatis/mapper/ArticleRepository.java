package com.powernode.mybatis.mapper;

import com.powernode.mybatis.po.ArticlePO;
import com.powernode.mybatis.provider.SqlProvider;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface ArticleRepository {

    @Select("")
    @Results(id = "NewBaseArticleMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "title", property = "title"),
            @Result(column = "summary", property = "summary"),
            @Result(column = "read_count", property = "readCount"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    ArticlePO articleMapper();


    @ResultMap("NewBaseArticleMap")
    @SelectProvider(type = SqlProvider.class, method = "selectArticle")
    ArticlePO selectByPrimary(Integer id);



    @UpdateProvider(type = SqlProvider.class, method = "updateSql")
    int updateTime(Integer id, LocalDateTime newTime);


    @InsertProvider(type = SqlProvider.class, method = "insertSql")
    int insertArticle(ArticlePO articlePO);

    @DeleteProvider(type = SqlProvider.class, method = "deleteSql")
    int deleteById(Integer id);
}
