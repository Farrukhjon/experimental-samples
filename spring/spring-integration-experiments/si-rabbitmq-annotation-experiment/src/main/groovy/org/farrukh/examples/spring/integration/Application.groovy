package org.farrukh.examples.spring.integration

import org.farrukh.examples.spring.integration.handler.GreetingServiceActivatorByAnnotation
import org.farrukh.examples.spring.integration.handler.GreetingTransformerByImplementation
import org.springframework.amqp.core.*
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.listener.AbstractMessageListenerContainer
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import org.springframework.integration.amqp.inbound.AmqpInboundChannelAdapter
import org.springframework.integration.amqp.outbound.AmqpOutboundEndpoint
import org.springframework.integration.channel.DirectChannel
import org.springframework.integration.handler.MessageHandlerChain
import org.springframework.integration.handler.ServiceActivatingHandler
import org.springframework.integration.support.json.Jackson2JsonObjectMapper
import org.springframework.integration.transformer.MessageTransformingHandler
import org.springframework.messaging.MessageChannel

@SpringBootApplication
@EnableConfigurationProperties(ApplicationProperties)
class Application {

    static void main(String[] args) {
        SpringApplication.run Application, args
    }

    @Bean
    Jackson2JsonObjectMapper jsonObjectMapper() {
        new Jackson2JsonObjectMapper(Jackson2ObjectMapperBuilder.json().build())
    }

    @Bean
    SimpleMessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory, ApplicationProperties configuration) {
        def messageListenerContainer = new SimpleMessageListenerContainer(connectionFactory: connectionFactory)
        messageListenerContainer.setQueueNames(configuration.queueName)
        messageListenerContainer
    }

    @Bean
    Queue queue(ApplicationProperties configuration) {
        new Queue(configuration.queueName)
    }

    @Bean
    FanoutExchange exchange(ApplicationProperties configuration) {
        new FanoutExchange(configuration.exchangeName, configuration.rabbitExchangeDurable, false)
    }

    @Bean
    Binding binding(Queue queue, FanoutExchange exchange) {
        BindingBuilder.bind(queue).to(exchange)
    }

    @Bean
    GreetingTransformerByImplementation greetingTransformer() {
        new GreetingTransformerByImplementation()
    }

    @Bean
    GreetingServiceActivatorByAnnotation greetingServiceActivator() {
        new GreetingServiceActivatorByAnnotation()
    }

    @Bean
    AmqpOutboundEndpoint amqpOutboundEndpoint(AmqpTemplate rabbitTemplate, ApplicationProperties configuration) {
        new AmqpOutboundEndpoint(rabbitTemplate).with {
            exchangeName = configuration.exchangeName
            routingKey = configuration.queueName
            it
        }
    }

    @Bean
    MessageChannel outputChannel(AmqpOutboundEndpoint amqpOutboundEndpoint) {
        def channel = new DirectChannel()
        channel.subscribe(amqpOutboundEndpoint)
        channel
    }

    @Bean
    MessageHandlerChain greetingChain(MessageChannel outputChannel) {
        def chain = new MessageHandlerChain()
        def handlers = []
        handlers << new MessageTransformingHandler(greetingTransformer())
        handlers << new ServiceActivatingHandler(greetingServiceActivator())
        chain.handlers = handlers
        chain.outputChannel = outputChannel
        chain
    }

    @Bean
    MessageChannel inputChannel(MessageChannel outputChannel) {
        def channel = new DirectChannel()
        channel.subscribe(greetingChain(outputChannel))
        channel
    }

    @Bean
    AmqpInboundChannelAdapter amqpInboundChannelAdapter(AbstractMessageListenerContainer messageListenerContainer,
                                                    MessageChannel inputChannel,
                                                    MessageChannel errorChannel) {
        new AmqpInboundChannelAdapter(messageListenerContainer).with {
            it.outputChannel = inputChannel
            it.errorChannel = errorChannel
            it
        }

    }

}
