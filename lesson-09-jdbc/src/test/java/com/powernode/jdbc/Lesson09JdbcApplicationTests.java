package com.powernode.jdbc;

import com.powernode.jdbc.model.ArticleDetailPO;
import com.powernode.jdbc.model.ArticleMainPO;
import com.powernode.jdbc.model.ArticlePO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class Lesson09JdbcApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void test01() {
        String sql = "select count(1) as ct from article";
        Long count = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println("total rows = " + count);
    }


    @Test
    void test02() {
        String sql = "select * from article where id = ?";
        ArticlePO articlePO = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(ArticlePO.class), 1);
        System.out.println(articlePO);
    }

    @Test
    void test03() {
        String sql = "select * from article where id = 1";
        ArticlePO articlePO = jdbcTemplate.queryForObject(sql, (rs, rownum) -> {
            System.out.println("rs=" + rs);

            var id = rs.getInt("id");
            var userId = rs.getInt("user_id");
            var title = rs.getString("title");
            var summary = rs.getString("summary");
            var readCount = rs.getInt("read_count");
            var createTime = new Timestamp(rs.getTimestamp("create_time").getTime()).toLocalDateTime();
            var updateTime = new Timestamp(rs.getTimestamp("update_time").getTime()).toLocalDateTime();

            return new ArticlePO(id, userId, title, summary, readCount, createTime, updateTime);
        });

        System.out.println(articlePO.toString());
    }


    @Test
    void test04() {
        String sql = "select * from article order by id";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        maps.forEach(el -> {
            el.forEach((field, value) -> {
                System.out.println(field + ", " + value);
            });
            System.out.println("------------------------------");
        });
    }

    @Test
    void test05() {
        String sql = "update article set title = ? where id = ?";
        int rows = jdbcTemplate.update(sql, "Java编程实现", 2);
        System.out.println(rows);

    }

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Test
    void test06() {
        String sql = "select count(1) as ct from article where user_id = :uid and read_count > :num";
        Map<String, Object> param = new HashMap<>();
        param.put("uid", 2101);
        param.put("num", 10);

        Long counts = namedParameterJdbcTemplate.queryForObject(sql, param, Long.class);
        System.out.println(counts);

    }


    @Test
    void test07(){
        String sql = """
                select m.*,d.id as detail_id, d.article_id,d.content
                from article m join article_detail d
                on m.id = d.article_id
                where m.id=:id
                """;
        Map<String, Object> param = new HashMap<>();
        param.put("id", 1);

        List<ArticleMainPO> list = namedParameterJdbcTemplate.query(sql, param, (rs, num) -> {
            var id = rs.getInt("id");
            var userId = rs.getInt("user_id");
            var title = rs.getString("title");
            var summary = rs.getString("summary");
            var readCount = rs.getInt("read_count");
            var createTime = new Timestamp(rs.getTimestamp("create_time").getTime()).toLocalDateTime();
            var updateTime = new Timestamp(rs.getTimestamp("update_time").getTime()).toLocalDateTime();

            var detailId = rs.getInt("detail_id");
            var content = rs.getString("content");
            var articleId = rs.getInt("article_id");

            ArticleDetailPO detail = new ArticleDetailPO();
            detail.setId(detailId);
            detail.setArticleId(articleId);
            detail.setContent(content);

            return new ArticleMainPO(id, userId, title, summary, readCount,
                    createTime, updateTime, detail);
        });

        list.forEach(m -> {
            System.out.println("m.getId()=" + m.getId());
            System.out.println("m.getArticleDetail()=" + m.getArticleDetail());
        });


    }

}
