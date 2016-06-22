package org.farrukh.examples.spring.integration.handler

import groovy.util.logging.Slf4j
import org.springframework.integration.annotation.ServiceActivator

/**
 * Created by Farrukhjon SATTOROV.
 */
@Slf4j
class GreetingServiceActivatorByAnnotation {

    @ServiceActivator
    String handleGreeting(String greeting) {
        log.info("The message {} was handled by {}", greeting, GreetingServiceActivatorByAnnotation)
        greeting
    }
}
