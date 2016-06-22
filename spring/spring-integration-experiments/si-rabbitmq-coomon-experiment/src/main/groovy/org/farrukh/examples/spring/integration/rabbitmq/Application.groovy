package org.farrukh.examples.spring.integration.rabbitmq

import org.farrukh.examples.spring.integration.rabbitmq.handler.HelloServiceActivator
import org.springframework.amqp.core.AcknowledgeMode
import org.springframework.amqp.core.AmqpTemplate
import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.Exchange
import org.springframework.amqp.core.FanoutExchange
import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ImportResource
import org.springframework.core.task.TaskExecutor
import org.springframework.integration.channel.MessagePublishingErrorHandler
import org.springframework.util.ErrorHandler

@SpringBootApplication
@ImportResource('classpath:META-INF/spring/application-context.xml')
@EnableConfigurationProperties(ApplicationProperties)
class Application {

    static void main(String[] args) {
        SpringApplication.run Application, args
    }

    @Bean
    AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        new RabbitTemplate(connectionFactory: connectionFactory)
    }

    @Bean
    SimpleMessageListenerContainer exampleListenerContainer(ConnectionFactory connectionFactory,
                                                            ApplicationProperties configuration,
                                                            TaskExecutor taskExecutor,
                                                            ErrorHandler errorHandler) {
        def container = new SimpleMessageListenerContainer(connectionFactory: connectionFactory,
                acknowledgeMode: AcknowledgeMode.AUTO,
                channelTransacted: false,
                concurrentConsumers: configuration.rabbitChannelCacheSize,
                defaultRequeueRejected: false,
                prefetchCount: configuration.rabbitPrefetchCount,
                receiveTimeout: 1000,
                recoveryInterval: 5000,
                shutdownTimeout: 5000,
                taskExecutor: taskExecutor,
                txSize: 1,
                errorHandler: errorHandler)
        container.setQueueNames(configuration.rabbitQueueName)
        container

    }

    @Bean
    MessagePublishingErrorHandler errorHandler() {
        new MessagePublishingErrorHandler()
    }

    @Bean
    Queue queue(ApplicationProperties configuration) {
        new Queue(configuration.rabbitQueueName)
    }

    @Bean
    Exchange exchange(ApplicationProperties configuration) {
        new FanoutExchange(configuration.rabbitExchangeName, configuration.rabbitExchangeDurable, false)
    }

    @Bean
    Binding binding(Queue queue, Exchange exchange) {
        // the docs contain much simple examples for binding queues to exchanges, but the libraries we are pulling in don't seem to match the docs
        new Binding(queue.name, Binding.DestinationType.QUEUE, exchange.name, '', [:])
    }

    @Bean
    HelloServiceActivator helloHandler() {
        new HelloServiceActivator()
    }

}
