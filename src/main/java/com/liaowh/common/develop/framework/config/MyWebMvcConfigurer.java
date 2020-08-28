package com.liaowh.common.develop.framework.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    private final Logger logger = LoggerFactory.getLogger(MyWebMvcConfigurer.class);
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptorAdapter() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                JSONObject json = new JSONObject();
                json.put("ip", request.getRemoteAddr());
                json.put("requestInterface:", request.getRequestURI());
                json.put("param",request.getParameterMap());
                logger.info(json.toString());
                return true;
            }
        });
    }

}