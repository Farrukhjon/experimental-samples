package org.farrukh.examples.spring.mvc.interceptor.interceptor

import org.springframework.web.HttpMediaTypeNotSupportedException
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class CustomInterceptor extends HandlerInterceptorAdapter {

    @Override
    boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.contentType == null)
            throw new RuntimeException('Content type could not be null')
        else if (request.contentType != 'json/ application')
            throw new HttpMediaTypeNotSupportedException('Content-Type could not be null')

    }

    @Override
    void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView)
    }

    @Override
    void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex)
    }

    @Override
    void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler)
    }
}
