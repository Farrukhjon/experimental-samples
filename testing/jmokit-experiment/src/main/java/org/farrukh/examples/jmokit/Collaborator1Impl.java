package org.farrukh.examples.jmokit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Collaborator1Impl implements Collaborator1 {
    
    private static final Logger logger = LoggerFactory.getLogger(Collaborator1Impl.class);

    @Override
    public void doSomething() {
        logger.info("On do something method");
        System.out.println("I am doing something");
    }

}
