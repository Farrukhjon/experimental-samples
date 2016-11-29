package org.farrukh.experiments.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlogSubscriber implements Observer {

    private static final Logger logger = LoggerFactory.getLogger(BlogSubscriber.class);

    private String name;

    private List<String> messages = new ArrayList<>();

    public BlogSubscriber(String name, Observable observable) {
        this.name = name;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        messages.add(String.valueOf(arg));
        int messageCount = messages.size();
        if (messageCount > 10) {
            o.deleteObserver(this);
            logger.info("{} unsubscribed", name);
        } else {
            logger.info("{} is received this message: {}", name, arg);
        }
    }

}
