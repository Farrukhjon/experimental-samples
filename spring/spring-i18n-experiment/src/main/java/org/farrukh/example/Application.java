package org.farrukh.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@RestController
@SpringBootApplication
public class Application {

    @Autowired
    private MessageSource messageSource;

    @RequestMapping("/msg")
    public String getMessage(@RequestHeader("Accept-Language") Locale locale) {
        return messageSource.getMessage("key1", null, locale);
    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.US);
        return slr;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
