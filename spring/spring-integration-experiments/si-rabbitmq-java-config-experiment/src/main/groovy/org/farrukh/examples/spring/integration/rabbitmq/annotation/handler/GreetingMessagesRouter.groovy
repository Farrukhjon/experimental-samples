package org.farrukh.examples.spring.integration.rabbitmq.annotation.handler

import org.springframework.http.MediaType
import org.springframework.integration.annotation.Router
import org.springframework.messaging.Message

/**
 * Created by Farrukhjon SATTOROV.
 */
class GreetingMessagesRouter {

    @Router
    String route(Message<?> greeting) {
        def filteredChannel = 'ignoredChannel'
        def contentType = greeting.headers.get('content-type') as String
        if (contentType == MediaType.APPLICATION_JSON_VALUE) {
            filteredChannel = 'greetingChannel'
        }
        filteredChannel
    }
}
