package com.no3003.fatlonely.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author: lz
 * @Date: 2021/4/27 19:40
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object jsessionid = session.getAttribute("JSESSIONID");
        if (jsessionid != null){
            return true;
        }
        StringBuffer url = request.getRequestURL();
        String loginUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append("/login.do").toString();
        response.sendRedirect(loginUrl);
        return false;
    }
}
