package org.farrukh.examples.spring.integration.rabbitmq.annotation.handler

import org.springframework.http.MediaType
import org.springframework.messaging.Message

/**
 * Created by Farrukhjon SATTOROV.
 */
class GreetingMessageFilterSelector {

    boolean handleMessage(Message<?> message) {
        message.headers.get('media-type') == MediaType.APPLICATION_JSON && message.payload == 'Hello world! has been transformed'
    }
}
