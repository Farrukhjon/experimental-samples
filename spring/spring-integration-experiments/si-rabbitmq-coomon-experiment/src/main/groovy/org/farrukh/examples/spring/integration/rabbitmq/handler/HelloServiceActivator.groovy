package org.farrukh.examples.spring.integration.rabbitmq.handler

import groovy.util.logging.Slf4j
import org.springframework.integration.annotation.ServiceActivator

/**
 * Created by Farrukhjon SATTOROV.
 */
@Slf4j
class HelloServiceActivator {

    @ServiceActivator
    String handleMessage(String message) {
        log.info('The message {} has been sent!', message)
        message
    }
}
