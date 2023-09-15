package com.powernode.web.config;

import com.powernode.web.filter.AuthFilter;
import com.powernode.web.filter.LogFilter;
import com.powernode.web.servlet.LoginServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
public class WebAppConfig {


    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean();
        registrationBean.setServlet(new LoginServlet());
        registrationBean.addUrlMappings("/user/login");
        registrationBean.setLoadOnStartup(1);
        return registrationBean;
    }


/*    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();

        filterRegistrationBean.setFilter(new LogFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }*/


    @Bean
    public FilterRegistrationBean addLogFilter() {
        FilterRegistrationBean log = new FilterRegistrationBean();
        log.setFilter(new LogFilter());
        log.addUrlPatterns("/*");
        log.setOrder(2);
        return log;
    }

    @Bean
    public FilterRegistrationBean addAuthFilter() {
        FilterRegistrationBean auth = new FilterRegistrationBean();
        auth.setFilter(new AuthFilter());
        auth.addUrlPatterns("/*");
        auth.setOrder(1);
        return auth;
    }


    // 登记框架内置的Filter
    @Bean
    public FilterRegistrationBean addCommonsLogFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        CommonsRequestLoggingFilter commonsRequestLoggingFilter =  new CommonsRequestLoggingFilter();
        registrationBean.setFilter(commonsRequestLoggingFilter);
        registrationBean.addUrlPatterns("/*");

        return registrationBean;
    }
}
