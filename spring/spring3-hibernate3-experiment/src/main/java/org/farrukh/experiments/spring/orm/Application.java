package org.farrukh.experiments.spring.orm;

import org.farrukh.experiments.spring.orm.hibernate3.config.SpringHibernateJavaConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    
    static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        try (ConfigurableApplicationContext appContext = new AnnotationConfigApplicationContext(SpringHibernateJavaConfig.class)) {
           
        }
    }

}
