package org.farrukh.experiments.java;

import java.util.Observable;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Blogger extends Observable {
    
    private static final Logger logger = LoggerFactory.getLogger(Blogger.class);

    private void setBlogContent(String blogContent) {
        setChanged();
        notifyObservers(blogContent);
    }

    public void generateBlog() {
        logger.info("Generating blogs is started");
        while (countObservers() > 0) {
            String aBlogMsg = UUID.randomUUID().toString();
            setBlogContent(aBlogMsg);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        logger.info("Generating blogs is stopped due to lack of subscribers");
    }
    

}
