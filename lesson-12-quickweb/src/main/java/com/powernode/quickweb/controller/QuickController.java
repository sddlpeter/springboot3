package com.powernode.quickweb.controller;


import com.powernode.quickweb.vo.RoleVO;
import com.powernode.quickweb.vo.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


/**
 * 控制器接受请求，响应结果给浏览器
 */
@Controller
public class QuickController {

    // 定义方法处理请求
    @RequestMapping("/exam/quick")
    public String quick(Model model) {
        // 模拟调用service处理请求，获取数据
        // model里的数据，最终会放到request作用域，相当于 request.setAttribute("title", "WEB开发");
        model.addAttribute("title", "web开发");
        model.addAttribute("time", LocalDateTime.now());

        return "quick";
    }

    @GetMapping("/hello")
    public ModelAndView hello() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("name", "liSi");
        mv.addObject("age", 20);
        mv.setViewName("hello");
        return mv;
    }


    @GetMapping("/json")
    @ResponseBody
    public User returnJson() {
        User user = new User();
        user.setUsername("zhangSan");
        user.setAge(20);
        RoleVO roleVO = new RoleVO();
        roleVO.setId(1);
        roleVO.setRoleName("admin");
        roleVO.setMemo("cyber security is important");
        user.setRoleVO(roleVO);

        return user;
    }


    @GetMapping("/json3")
    @ResponseBody
    public ResponseEntity<User> returnEntity() {
        User user = new User();
        user.setUsername("zhangSan");
        user.setAge(20);
        RoleVO roleVO = new RoleVO();
        roleVO.setId(1);
        roleVO.setRoleName("admin");
        roleVO.setMemo("cyber security is important");
        user.setRoleVO(roleVO);

        ResponseEntity<User> response = new ResponseEntity<>(user, HttpStatus.OK);
        return response;
    }


    @GetMapping("/map")
    @ResponseBody
    public Map<String, Object> returnMap() {
        Map<String, Object> map = new HashMap<>();

        map.put("name", "liSi");
        map.put("age", 20);

        return map;
    }

    @GetMapping("/param/date")
    @ResponseBody
    public String paramDate(LocalDateTime date) {
        return "date: " + date;
    }

}
