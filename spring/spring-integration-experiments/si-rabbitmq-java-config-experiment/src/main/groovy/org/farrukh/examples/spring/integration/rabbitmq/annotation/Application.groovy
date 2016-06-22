package org.farrukh.examples.spring.integration.rabbitmq.annotation

import org.farrukh.examples.spring.integration.rabbitmq.annotation.handler.GreetingHeaderEnricher
import org.farrukh.examples.spring.integration.rabbitmq.annotation.handler.GreetingMessageFilterSelector
import org.farrukh.examples.spring.integration.rabbitmq.annotation.handler.GreetingMessagesRouter
import org.farrukh.examples.spring.integration.rabbitmq.annotation.handler.GreetingServiceActivatorByAnnotation
import org.farrukh.examples.spring.integration.rabbitmq.annotation.handler.GreetingTransformerByImplementation
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
import org.springframework.integration.amqp.support.AmqpHeaderMapper
import org.springframework.integration.amqp.support.DefaultAmqpHeaderMapper
import org.springframework.integration.channel.DirectChannel
import org.springframework.integration.config.EnableMessageHistory
import org.springframework.integration.filter.MessageFilter
import org.springframework.integration.filter.MethodInvokingSelector
import org.springframework.integration.handler.LoggingHandler
import org.springframework.integration.handler.MessageHandlerChain
import org.springframework.integration.handler.ServiceActivatingHandler
import org.springframework.integration.mapping.AbstractHeaderMapper
import org.springframework.integration.router.MethodInvokingRouter
import org.springframework.integration.support.json.Jackson2JsonObjectMapper
import org.springframework.integration.transformer.HeaderEnricher
import org.springframework.integration.transformer.MessageTransformingHandler
import org.springframework.integration.transformer.support.MessageProcessingHeaderValueMessageProcessor
import org.springframework.messaging.MessageChannel

@SpringBootApplication
@EnableMessageHistory
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
    GreetingHeaderEnricher greetingHeaderEnricher() {
        new GreetingHeaderEnricher()
    }

    @Bean
    HeaderEnricher headerEnricher() {
        def headerValueMessageProcessor = new MessageProcessingHeaderValueMessageProcessor(greetingHeaderEnricher(), 'handleHeaders')
        new HeaderEnricher(['media-type': headerValueMessageProcessor])
    }

    @Bean
    LoggingHandler loggingHandler() {
        new LoggingHandler('INFO')
    }

    @Bean
    MessageChannel ignoredEventsChannel() {
        def channel = new DirectChannel()
        channel.subscribe(loggingHandler())
        channel
    }

    @Bean
    MessageFilter messageFilter() {
        def messageSelector = new GreetingMessageFilterSelector()
        def messageFilter = new MessageFilter(new MethodInvokingSelector(messageSelector, 'handleMessage'))
        messageFilter.discardChannel = ignoredEventsChannel()
        messageFilter
    }

    @Bean
    GreetingMessagesRouter greetingMessagesRouter() {
        new GreetingMessagesRouter()
    }

    @Bean
    MethodInvokingRouter methodInvokingRouter(GreetingMessagesRouter greetingMessagesRouter) {
        new MethodInvokingRouter(greetingMessagesRouter)
    }

    @Bean
    MessageHandlerChain greetingChain(final HeaderEnricher headerEnricher,
                                      final GreetingTransformerByImplementation greetingTransformer,
                                      final MessageFilter messageFilter,
                                      final GreetingServiceActivatorByAnnotation greetingServiceActivator,
                                      final MethodInvokingRouter methodInvokingRouter) {
        def chain = new MessageHandlerChain()
        def handlers = []
        handlers << new MessageTransformingHandler(headerEnricher)
        handlers << new MessageTransformingHandler(greetingTransformer)
        handlers << messageFilter
        handlers << new ServiceActivatingHandler(greetingServiceActivator)
        handlers << methodInvokingRouter
        chain.handlers = handlers
        //chain.outputChannel = outputChannel
        chain
    }

    @Bean
    MessageChannel inputChannel(MessageHandlerChain greetingChain) {
        def channel = new DirectChannel()
        channel.subscribe(greetingChain /*(outputChannel)*/)
        channel
    }

    @Bean
    AmqpHeaderMapper customHeaderMapper() {
        def headerMapper = new DefaultAmqpHeaderMapper()
        headerMapper.setRequestHeaderNames(AbstractHeaderMapper.NON_STANDARD_HEADER_NAME_PATTERN)
        headerMapper.setReplyHeaderNames(AbstractHeaderMapper.STANDARD_REPLY_HEADER_NAME_PATTERN)
        headerMapper
    }

    @Bean
    AmqpInboundChannelAdapter amqpInboundChannelAdapter(AbstractMessageListenerContainer messageListenerContainer,
                                                        MessageChannel inputChannel,
                                                        MessageChannel errorChannel,
                                                        AmqpHeaderMapper customHeaderMapper) {
        new AmqpInboundChannelAdapter(messageListenerContainer).with {
            it.outputChannel = inputChannel
            it.errorChannel = errorChannel
            it.headerMapper = customHeaderMapper
            it
        }

    }

}
