package org.farrukh.examples.spring.integration.rabbitmq

import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.integration.support.MessageBuilder
import org.springframework.messaging.MessageChannel
import org.springframework.messaging.PollableChannel

import javax.annotation.Resource

/**
 * Created by Farrukhjon SATTOROV.
 */
class HelloMessageIntegrationTest extends AbstractBaseIntegrationTest {

    @Resource(name = 'example-input-channel')
    MessageChannel messageChannel

    @Resource(name = 'example-receive-channel')
    PollableChannel pollableChannel

    @Autowired
    RabbitTemplate rabbitTemplate

    def 'exercise send message'() {
        given: 'a valid message'
        def greeting = 'Hello world!'
        def expectedMessage = greeting.toUpperCase()
        def message = MessageBuilder.withPayload(greeting).build()

        when:'message is sent'
        def isSent = messageChannel.send(message)

        and: 'the message is requested'
        def result = pollableChannel.receive()

        then: 'the expected message is returned'
        isSent
        result.payload == expectedMessage
    }

}
