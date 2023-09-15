package com.powernode.tpl.controller;


import com.powernode.tpl.vo.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.service.annotation.GetExchange;

import java.util.Arrays;
import java.util.List;

@Controller
public class ThymeleafController {

    @GetMapping("/expression")
    public String exp(Model model) {
        model.addAttribute("name", "动力节点IT培训");
        model.addAttribute("address", "北京大兴区");
        return "exp";  // 是一个视图，exp.html
    }


    @GetMapping("/link")
    public String link(Model model, Integer id, String name ) {
        model.addAttribute("id", id);
        model.addAttribute("myName", name);

        return "link";
    }

    @GetMapping("/if-for")
    public String ifFor(Model model) {
        model.addAttribute("login", true);
        UserVO userVO = new UserVO();
        userVO.setId(10);
        userVO.setName("李四");
        userVO.setAge(20);

        model.addAttribute("user", userVO);

        List<UserVO> users = Arrays.asList(
                new UserVO(11, "zhangSan", 21),
                new UserVO(12, "wangWu", 23)
        );

        model.addAttribute("users", users);

        return "base";
    }
}