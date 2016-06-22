package org.farrukh.examples.spring.integration.rabbitmq.annotation

import org.springframework.amqp.core.AmqpTemplate
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.FanoutExchange
import org.springframework.amqp.core.MessageBuilder
import org.springframework.amqp.core.MessageDeliveryMode
import org.springframework.amqp.core.MessageProperties
import org.springframework.amqp.core.MessagePropertiesBuilder
import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.core.RabbitAdmin
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.http.MediaType
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification
import spock.util.concurrent.PollingConditions

import static java.nio.charset.StandardCharsets.UTF_8

/**
 * Created by Farrukhjon SATTOROV.
 */
@ContextConfiguration(classes = Application, loader = SpringApplicationContextLoader)
class GreetingMessageFlowIntegrationTest extends Specification {

    @Autowired
    RabbitAdmin rabbitAdmin

    @Autowired
    AmqpTemplate rabbitTemplate

    @Autowired
    FanoutExchange exchange

    @Autowired
    ApplicationProperties configuration

    def queueName

    def setup() {
        queueName = configuration.queueName
        assert rabbitTemplate
        rabbitAdmin.deleteQueue(queueName)
        def queue = new Queue(queueName, false, false, false)
        rabbitAdmin.declareQueue(queue)
        rabbitAdmin.declareBinding(BindingBuilder.bind(queue).to(exchange))
    }

    def cleanup() {
        queueName = configuration.queueName
        rabbitAdmin.deleteQueue(queueName)
    }

    def 'exercise message via rabbit-inputChannel-amqpInbound-transformer-outputChannel-amqpOutbound'() {
        given:
        def payload = 'Hello world!'

        and:
        def expectedPayload = payload + ' has been transformed'
        def expectedContentType = MediaType.APPLICATION_JSON_VALUE
        def expectedAppId = UUID.randomUUID().toString()

        and:
        def messageProperties = MessagePropertiesBuilder.newInstance()
                .setAppId(expectedAppId)
                .setTimestamp(new Date())
                .setContentType(expectedContentType)
                .setMessageId(UUID.randomUUID().toString())
                .setDeliveryMode(MessageDeliveryMode.PERSISTENT)
                .setCorrelationId(UUID.randomUUID().toString().getBytes(UTF_8))
                .build()
        def message = MessageBuilder.withBody(payload.bytes)
                .andProperties(messageProperties)
                .build()

        when:
        rabbitTemplate.send(configuration.exchangeName, configuration.queueName, message)

        then:
        new PollingConditions(timeout: 50, delay: 10).eventually {
            def result = rabbitTemplate.receive(configuration.queueName)
            result
            //result.body == expectedPayload.bytes
            result.messageProperties.appId == expectedAppId
            result.messageProperties.contentType == expectedContentType
        }
    }

}
