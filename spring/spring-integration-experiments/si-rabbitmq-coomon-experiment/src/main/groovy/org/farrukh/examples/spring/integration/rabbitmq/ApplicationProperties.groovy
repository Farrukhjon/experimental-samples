package org.farrukh.examples.spring.integration.rabbitmq

import org.springframework.boot.context.properties.ConfigurationProperties

/**
 * Created by Farrukhjon SATTOROV.
 */
@ConfigurationProperties(prefix = 'example-app', ignoreUnknownFields = false)
class ApplicationProperties {

    /**
     * The number of channels to maintain in the rabbit connection cache.
     */
    int rabbitChannelCacheSize

    /**
     * Tells the broker how many messages to send to each consumer in a single request.
     */
    int rabbitPrefetchCount

    /**
     * The name of the rabbit queue to receive messages from.
     */
    String rabbitQueueName

    /**
     * The name of the rabbit exchange to bind to.
     */
    String rabbitExchangeName

    /**
     * Whether or not the rabbit exchange is 'durable'.
     */
    boolean rabbitExchangeDurable

    /**
     * The number of threads to allocate to the thread pool.
     */
    int threadPoolSize

}
