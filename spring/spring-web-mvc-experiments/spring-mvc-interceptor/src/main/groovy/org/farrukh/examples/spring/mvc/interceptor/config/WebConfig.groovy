package org.farrukh.examples.spring.mvc.interceptor.config

import org.farrukh.examples.spring.mvc.interceptor.interceptor.CustomInterceptor
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
@Configuration
class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CustomInterceptor())
    }
}
