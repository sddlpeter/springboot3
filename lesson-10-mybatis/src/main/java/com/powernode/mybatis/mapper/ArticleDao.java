package com.powernode.mybatis.mapper;

import com.powernode.mybatis.po.ArticlePO;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ArticleDao {
    @Select("""
            select id,user_id,title,summary,read_count,create_time,update_time from article
            where user_id=#{userId}
            """)
    @Results(id = "BaseArticleMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "title", property = "title"),
            @Result(column = "summary", property = "summary"),
            @Result(column = "read_count", property = "readCount"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    List<ArticlePO> selectList(Integer userId);


    @Select("""
            select id,user_id,title,summary,read_count,create_time,update_time from article
            where id=#{id}
            """)
    // @ResultMap("BaseArticleMap")
    @ResultMap("ArticleBaseMapper")
    ArticlePO selectById(Integer id);

}
