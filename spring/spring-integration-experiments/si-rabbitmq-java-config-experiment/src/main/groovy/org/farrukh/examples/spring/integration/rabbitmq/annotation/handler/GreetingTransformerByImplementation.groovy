package org.farrukh.examples.spring.integration.rabbitmq.annotation.handler

import groovy.util.logging.Slf4j
import org.springframework.integration.support.MessageBuilder
import org.springframework.integration.transformer.Transformer
import org.springframework.messaging.Message

/**
 * Created by Farrukhjon SATTOROV.
 */
@Slf4j
class GreetingTransformerByImplementation implements Transformer {

    @Override
    Message<?> transform(Message<?> message) {
        def oldPayload = message.payload
        def newPayload = new String (oldPayload) + ' has been transformed'
        def transformedMessage = MessageBuilder.withPayload(newPayload).copyHeaders(message.headers).build()
        log.info("The message {} was handled by {} and has been transformed", message, GreetingTransformerByImplementation)
        transformedMessage
    }
}
