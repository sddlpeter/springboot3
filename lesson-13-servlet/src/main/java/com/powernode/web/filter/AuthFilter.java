package com.powernode.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

// @WebFilter("/*")
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String uri = ((HttpServletRequest) request).getRequestURI().toString();
        System.out.println("==========AuthFilter执行了. uri: " + uri);

        // 放行
        chain.doFilter(request, response);
    }
}
