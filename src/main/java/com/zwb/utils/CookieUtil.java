package com.zwb.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Desc:
 * @Author: zwb
 * @CreateTime: 2020/6/9 13:56
 **/
public class CookieUtil {

    /**
     * 设置cookie
     *
     * @param httpServletResponse
     * @param name
     * @param value
     * @param maxAge
     */
    public static void set(HttpServletResponse httpServletResponse,
                           String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        httpServletResponse.addCookie(cookie);
    }

    /**
     * 获取cookie
     *
     * @param httpServletRequest
     * @param name
     * @return
     */
    public static Cookie get(HttpServletRequest httpServletRequest, String name) {
        Map<String, Cookie> cookieMap = readCookieMap(httpServletRequest);
        if (cookieMap.containsKey(name)) {
            return cookieMap.get(name);
        } else {
            return null;
        }
    }

    /**
     * 将cookie封装成map
     *
     * @param httpServletRequest
     * @return
     */
    private static Map<String, Cookie> readCookieMap(HttpServletRequest httpServletRequest) {
        Map<String, Cookie> cookieMap = new HashMap<>();
        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }
}
