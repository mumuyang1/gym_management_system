package com.tw.core.utils;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NotLoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handle) {
        if (request.getServletPath().startsWith("/users/login") || request.getServletPath().startsWith("/users/sign-up")) {
            return true;
        }

        if (request.getSession().getAttribute("isLogin") != null) {
            return true;
        }
        try {
            String fromUrl = request.getServletPath();

            Cookie cookie = new Cookie("fromUrl", fromUrl);
            response.addCookie(cookie);
            response.sendRedirect(request.getContextPath() + "/users/login");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
