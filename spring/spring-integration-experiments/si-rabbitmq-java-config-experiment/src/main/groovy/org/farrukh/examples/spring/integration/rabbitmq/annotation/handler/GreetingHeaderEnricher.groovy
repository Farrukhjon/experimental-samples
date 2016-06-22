package org.farrukh.examples.spring.integration.rabbitmq.annotation.handler

import groovy.util.logging.Slf4j
import org.springframework.amqp.support.AmqpHeaders
import org.springframework.http.MediaType
import org.springframework.messaging.Message

/**
 * Created by Farrukhjon SATTOROV.
 */
@Slf4j
class GreetingHeaderEnricher {

    MediaType handleHeaders(Message<?> greetingMessage) {
        def contentType = greetingMessage.headers.get(AmqpHeaders.CONTENT_TYPE) as String
        def mediaType = MediaType.valueOf(contentType)
        mediaType == MediaType.APPLICATION_JSON ? mediaType: MediaType.APPLICATION_JSON
        log.info("The header content type of the message {} has been enriched", greetingMessage)
        mediaType
    }

}
