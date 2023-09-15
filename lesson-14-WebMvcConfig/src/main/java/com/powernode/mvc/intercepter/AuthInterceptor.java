package com.powernode.mvc.intercepter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class AuthInterceptor implements HandlerInterceptor {

    private static final String COMMON_USER="zhangSan";

    // 判断登录的用户，能否执行响应的操作
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("========权限拦截器执行了=========");
        String loginUser = request.getParameter("loginUser");
        String requestURI = request.getRequestURI();

        // 如果用户的操作是增加，修改，删除，那么拦截器拦截，否则放行
        if (COMMON_USER.equals(loginUser) && (
            requestURI.startsWith("/article/add") ||
            requestURI.startsWith("/article/remove") ||
            requestURI.startsWith("/article/edit"))) {
            return false;
        }
        return true;
    }
}
