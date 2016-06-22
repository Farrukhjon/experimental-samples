package org.farrukh.examples.spring.integration

import org.springframework.boot.context.properties.ConfigurationProperties

/**
 * Created by Farrukhjon SATTOROV.
 */
@ConfigurationProperties(prefix = 'app', ignoreInvalidFields = true)
class ApplicationProperties {

    String queueName
    String exchangeName
    boolean rabbitExchangeDurable
}
