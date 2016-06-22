package org.farrukh.examples.spring.event.listeners;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

public class ContextStartedEventExample implements ApplicationListener<ContextStartedEvent> {

    @Override
    public void onApplicationEvent(final ContextStartedEvent event) {
        System.out.println("context started event has been intercepted by ContextStartedEventExample");
    }
}
