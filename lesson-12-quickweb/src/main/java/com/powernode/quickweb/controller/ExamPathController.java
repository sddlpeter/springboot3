package com.powernode.quickweb.controller;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.OutputStream;
import java.io.Reader;
import java.util.Map;

@RestController
public class ExamPathController {

    @GetMapping("/file/tast.html")
    public String path1(HttpServletRequest request) {
        return "path请求: " + request.getRequestURI();
    }

    @GetMapping("/images/*.gif")
    public String path2(HttpServletRequest request) {
        return "path请求: " + request.getRequestURI();
    }

    @GetMapping("/pic/**")
    public String path3(HttpServletRequest request) {
        return "path请求: " + request.getRequestURI();
    }

    // 路径变量
    @GetMapping("/order/{*id}")
    public String path4(@PathVariable("id") String orderId, HttpServletRequest request) {
        return "path请求: " + request.getRequestURI() + " ,id=" + orderId;
    }


    @GetMapping("/pages/{fname:\\w+}.log")
    public String path5(@PathVariable("fname") String fname, HttpServletRequest request) {
        return "path请求: " + request.getRequestURI() + " ,fname=" + fname;
    }

    @GetMapping("/pages/get")
    public String path6( HttpServletRequest request) {
        return "path请求: " + request.getRequestURI();
    }


    public String req(ServletRequest request, ServletResponse response, HttpSession session,
                      Reader reader, OutputStream outputStream, @RequestParam("age") Integer age,
                      @RequestHeader("Accept") String accept, Map map, Model model,
                      Integer id, String time) {
        String requestId = request.getRequestId();
        response.setBufferSize(1024);
        session.setAttribute("name", "liSi");
        return "";
    }
}
