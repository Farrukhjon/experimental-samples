package org.farrukh.examples.spring.event.listeners;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationStartedEvent;

/**
 * Spring boot based stand-alone application.
 */
@SpringBootApplication
public class Application {

    public static void main(final String[] args) {
        new SpringApplicationBuilder().sources(Application.class)
                                      .listeners(event -> {
                                          if (event instanceof ApplicationStartedEvent) {
                                              System.out.printf("%s  %s", "####################", "Application started event occurred\n");
                                          }
                                          System.out.printf("%s %s %s", "#################### Event", event.getClass(), "occurred\n");
                                      })
                                      .run(args);
    }

}
