package com.powernode.mvc.settings;

import com.powernode.mvc.formatter.DeviceFormatter;
import com.powernode.mvc.intercepter.AuthInterceptor;
import com.powernode.mvc.intercepter.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MvcSettings implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DeviceFormatter());
    }

    // 页面跳转控制器，从请求直达视图页面
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/welcome").setViewName("index");
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 权限拦截器
        AuthInterceptor authInterceptor = new AuthInterceptor();
        registry.addInterceptor(authInterceptor)
                .order(2)
                .addPathPatterns("/article/**")
                .excludePathPatterns("/article/query");

        // 登录拦截器
        LoginInterceptor loginInterceptor = new LoginInterceptor();
        registry.addInterceptor(loginInterceptor)
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/article/query");
    }




}
