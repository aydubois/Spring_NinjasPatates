package org.abr.audreybr.middleware;

import org.abr.audreybr.entity.Session;
import org.abr.audreybr.service.SessionService;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class MyMiddleware implements HandlerInterceptor {


    private SessionService sessionService;

    public MyMiddleware(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        if (cookies == null || cookies.length == 0) response.sendRedirect("http://localhost:8081/login");
        String cookieValue = cookies[0].getValue();
        if (cookieValue.isEmpty()) response.sendRedirect("http://localhost:8081/login");
        Session session = sessionService.getSession(cookieValue);
        Date currentDate = new Date();
        int result = currentDate.compareTo(session.getValid_until());
        if(result > 0){
            response.sendRedirect("http://localhost:8081/login");
            return false;
        }else {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        Cookie[] cookies = request.getCookies();

    }
}
