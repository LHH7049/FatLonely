package com.no3003.fatlonely.interceptor;

import com.no3003.fatlonely.access.data.UserAccessConstant;
import org.springframework.util.StringUtils;
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
        String uid = (String) session.getAttribute(UserAccessConstant.F_L_ACCOUNT);
        if (StringUtils.hasText(uid)){
            return true;
        }
//        StringBuffer url = request.getRequestURL();
        String loginUrl = request.getContextPath() + "/login.html";
        response.sendRedirect(loginUrl);
        return false;
    }
}
