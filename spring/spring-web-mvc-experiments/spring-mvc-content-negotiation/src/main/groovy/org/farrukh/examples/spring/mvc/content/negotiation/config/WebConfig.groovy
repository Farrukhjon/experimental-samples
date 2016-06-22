package org.farrukh.examples.spring.mvc.content.negotiation.config

import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

/**
 * Created by Farrukhjon on 5/19/2015.
 */
@Configuration
class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters)
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder()
        converters.add(new MappingJackson2HttpMessageConverter(builder.build()))
        converters.add(new MappingJackson2XmlHttpMessageConverter(builder.createXmlMapper(true).build()))
    }
}
