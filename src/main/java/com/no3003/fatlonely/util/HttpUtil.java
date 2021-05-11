package com.no3003.fatlonely.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: lz
 * @Date: 2021/5/11 10:31
 */
public class HttpUtil {

    private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    public static String getClientIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        if (ip == null) {
            return "";
        }

        int pos = ip.indexOf(",");
        if (pos > 0) {
            String[] ipArray = ip.split(",");
            int i = 0;
            for (i = 0; i < ipArray.length; i++) {
                String ipSub = ipArray[i].trim();
                if (!"unknown".equalsIgnoreCase(ipSub)) {
                    ip = ipSub;
                    break;
                }
            }
            if (i >= ipArray.length) {
                logger.warn("IP is full of 'unknown'");
                ip = ipArray[i - 1].trim();
            }
        }

        if (ip.length() <= 16) {
            return ip;
        } else {
            logger.warn("IP of length > 16 : " + ip);
            return ip.substring(0, 16);
        }
    }

    public static String getIP(){
        HttpServletRequest request = getHttpServletRequest();
        if (request != null){
            return getClientIpAddress(request);
        }
        return "";
    }

    public static void setCookieValue(HttpServletResponse response, String name, String value, int expire){
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(expire);
        cookie.setSecure(false);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    public static HttpServletRequest getHttpServletRequest(){
        try {
            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            if (attr == null) {
                return null;
            }
            return attr.getRequest();
        } catch (Exception e) {
            return null;
        }
    }
}
