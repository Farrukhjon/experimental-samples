package org.farrukh.experiments.old.tech;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyBean {

    final Logger logger = LoggerFactory.getLogger(MyBean.class);
    
    @Autowired
    private SecondBean secondBean;

    public void sayHello() {
        secondBean.doSomething();
        logger.info("Hello World!");
        
    }

}
