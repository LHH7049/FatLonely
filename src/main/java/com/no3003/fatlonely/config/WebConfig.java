package com.no3003.fatlonely.config;

import com.no3003.fatlonely.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: lz
 * @Date: 2021/4/27 19:46
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> loginExcludePath = Arrays.asList("/access/*", "/**/*.html", "/**/*.js", "/**/*.css");
        InterceptorRegistration loginInterceptor = registry.addInterceptor(new LoginInterceptor());
        loginInterceptor.addPathPatterns("/**");
        loginInterceptor.excludePathPatterns(loginExcludePath);
    }


}
