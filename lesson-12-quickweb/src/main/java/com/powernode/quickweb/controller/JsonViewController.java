package com.powernode.quickweb.controller;

import com.powernode.quickweb.vo.User;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class JsonViewController {

    // 显示json试图，包含json数据
    @RequestMapping("exam/json")
    public void responseJson(HttpServletResponse response) throws IOException {
        String json = "{\"name\":\"lisi\",\"age\":20}";
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(json);
        out.flush();
        out.close();
    }


    /**
     * 接受请求的注解
     * @GetMapping: 接收get请求，简化的@RequestMapping(Method=RequestMethod.GET)
     * @PostMapping: 接收post请求
     * @PutMapping: 接收put请求
     * @DeleteMapping: 接收delete请求
     * @return
     */

    // 返回一个object，由springmvc框架使用jackson转为json
    // user --> Jackson 工具库的ObjectMapper对象 --> user 转换为json格式字符串 --> HttpServletResponse输出
    // @RequestMapping("/exam/json2")
    @GetMapping("/exam/json2")
    @ResponseBody // 等同于使用HttpServletResponse 将对象加入到 response里面
    public User getUserJson() {
        User user = new User();
        user.setUsername("zhangSan");
        user.setAge(22);
        return user;
    }
}
