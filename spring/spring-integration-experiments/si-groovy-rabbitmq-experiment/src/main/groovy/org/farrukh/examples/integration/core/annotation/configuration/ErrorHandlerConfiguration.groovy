package org.farrukh.examples.integration.core.annotation.configuration

import org.farrukh.examples.integration.core.xml.endpoint.AnnotationGlobalErrorHandler
import org.farrukh.examples.integration.core.xml.endpoint.AnnotationTransformer
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.integration.annotation.IntegrationComponentScan
import org.springframework.integration.channel.DirectChannel
import org.springframework.messaging.MessageChannel

/**
 * Created by Farrukhjon SATTOROV.
 */
@Configuration
@EnableAutoConfiguration
@IntegrationComponentScan(['org.farrukh.examples.spring.integration.core.annotation.gateway'])
class ErrorHandlerConfiguration {

    @Bean
    MessageChannel transformInputChannel() {
        new DirectChannel()
    }

    @Bean
    AnnotationTransformer annotationTransformer() {
        new AnnotationTransformer()
    }

    @Bean
    AnnotationGlobalErrorHandler annotationGlobalErrorHandler() {
        new AnnotationGlobalErrorHandler()
    }
}
