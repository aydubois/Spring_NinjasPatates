package org.abr.audreybr.config;

import org.abr.audreybr.middleware.MyMiddleware;
import org.abr.audreybr.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    SessionService sessionService;

    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new MyMiddleware(sessionService));
    }
}
