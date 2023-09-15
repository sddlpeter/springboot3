package com.powernode.mvc.intercepter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginInterceptor implements HandlerInterceptor {

    private List<String> permitUser = new ArrayList<>();

    public LoginInterceptor() {
        this.permitUser = Arrays.asList("zhangSan", "liSi", "admin");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("===========登录拦截器执行了==========");
        String loginUser = request.getParameter("loginUser");
        if (StringUtils.hasText(loginUser) && permitUser.contains(loginUser)) {
            return true;
        }
        return false;
    }
}
