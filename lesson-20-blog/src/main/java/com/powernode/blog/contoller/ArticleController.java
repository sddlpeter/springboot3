package com.powernode.blog.contoller;

import cn.hutool.core.bean.BeanUtil;
import com.powernode.blog.formatter.IdType;
import com.powernode.blog.handler.exp.IdTypeException;
import com.powernode.blog.model.dto.ArticleDTO;
import com.powernode.blog.model.param.ArticleParam;
import com.powernode.blog.model.po.ArticlePO;
import com.powernode.blog.model.vo.ArticleVO;
import com.powernode.blog.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping(value = {"/", "/article/hot"})
    public String showArticle(Model model) {
        List<ArticlePO> articlePOS = articleService.queryTopArticle();

        // po 转成vo
        List<ArticleVO> articleVOS = BeanUtil.copyToList(articlePOS, ArticleVO.class);

        // 添加数据
        model.addAttribute("articleList", articleVOS);
        return "/blog/articleList";
    }

    // 发布新文章
    @PostMapping("/article/add")
    public String addArticle(@Validated(ArticleParam.AddArticle.class) ArticleParam param) {
        // 业务逻辑，调用service
        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setContent(param.getContent());
        articleDTO.setSummary(param.getSummary());
        articleDTO.setTitle(param.getTitle());
        boolean add = articleService.addArticle(articleDTO);
        return "redirect:/article/hot";
    }


    // 查询文章的内容，以便于修改
    @GetMapping("/article/get")
    public String queryById(Integer id, Model model) {
        if (id != null && id > 0) {
            ArticleDTO articleDTO = articleService.queryByArticleId(id);
            System.out.println("content=" + articleDTO.getContent());
            // dto -> vo
            ArticleVO articleVO = BeanUtil.copyProperties(articleDTO, ArticleVO.class);
            model.addAttribute("article", articleVO);

            return "/blog/editArticle";
        } else {
            return "/blog/error/error";
        }

    }

    // 更新文章
    @PostMapping("/article/edit")
    public  String modifyArticle(@Validated(ArticleParam.EditArticle.class) ArticleParam param) {
        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setId(param.getId());
        articleDTO.setTitle(param.getTitle());
        articleDTO.setSummary(param.getSummary());
        articleDTO.setContent(param.getContent());
        boolean edit = articleService.modifyArticle(articleDTO);

        return "redirect:/article/hot";
    }

    // 删除文章  ids=1,2,5,6
    @PostMapping("/article/remove")
    public String removeArticle(@RequestParam("ids")IdType idType) {

        if (idType == null) {
            throw new IdTypeException("ID为空");
        }
        boolean delete = articleService.removeArticle(idType.getIdList());

        return "redirect:/article/hot";
    }

    @GetMapping("/article/detail/overview")
    @ResponseBody
    public String queryDetail(Integer id) {
        String top20Content = "无内容";
        if (id != null && id > 0) {
            top20Content = articleService.queryTop20Content(id);
        }
        return top20Content;
    }
}
