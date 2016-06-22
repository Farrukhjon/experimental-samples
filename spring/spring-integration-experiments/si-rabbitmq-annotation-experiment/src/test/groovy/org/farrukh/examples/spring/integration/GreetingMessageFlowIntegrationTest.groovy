package org.farrukh.examples.spring.integration

import org.springframework.amqp.core.AmqpTemplate
import org.springframework.amqp.core.MessageBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification
import spock.util.concurrent.PollingConditions

/**
 * Created by Farrukhjon SATTOROV.
 */
@ContextConfiguration(classes = Application, loader = SpringApplicationContextLoader)
class GreetingMessageFlowIntegrationTest extends Specification {

    @Autowired
    AmqpTemplate rabbitTemplate

    @Autowired
    ApplicationProperties configuration

    def setup() {
        assert rabbitTemplate
    }

    def 'exercise message via rabbit-inputChannel-amqpInbound-transformer-outputChannel-amqpOutbound'() {
        given:
        def payload = 'Hello world!'
        def message = MessageBuilder.withBody(payload.bytes).build()

        and:
        def expectedPayload = payload + ' has been transformed'

        when:
        rabbitTemplate.send(configuration.exchangeName, configuration.queueName, message)

        then:
        new PollingConditions(timeout: 50, delay: 10).eventually {
            def result = rabbitTemplate.receive(configuration.queueName)
            result
            result.body == expectedPayload.bytes
        }

    }


}
