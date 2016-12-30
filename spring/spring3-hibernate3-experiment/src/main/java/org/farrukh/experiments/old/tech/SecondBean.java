package org.farrukh.experiments.old.tech;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SecondBean {
    
    final Logger logger = LoggerFactory.getLogger(SecondBean.class);
    
    public void doSomething() {
        logger.info("Doing something...");
    }

}
