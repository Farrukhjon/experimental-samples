package org.farrukh.experiments.old.tech;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    
    static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        try (ConfigurableApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfigContext.class)) {
            MyBean myBean = appContext.getBean(MyBean.class);
            myBean.sayHello();
            logger.info("The bean: {} is invoked", myBean.getClass().getSimpleName());
        }
    }

}
