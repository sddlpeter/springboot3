package com.powernode.tran.mapper;

import com.powernode.tran.po.ArticleDetailPO;
import com.powernode.tran.po.ArticlePO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

public interface ArticleMapper {

    @Insert("""
            insert into article(user_id,title,summary,read_count,create_time,update_time)
            values(#{userId},#{title},#{summary},#{readCount},#{createTime},#{updateTime})
            """)
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    int insertArticle(ArticlePO article);


    @Insert("""
            insert into article_detail(article_id, content)
            values (#{articleId},#{content})
            """)
    int insertDetail(ArticleDetailPO articleDetail);
}
