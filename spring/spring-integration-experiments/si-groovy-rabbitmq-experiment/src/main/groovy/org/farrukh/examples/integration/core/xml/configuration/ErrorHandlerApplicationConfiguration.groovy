package org.farrukh.examples.integration.core.xml.configuration

import org.farrukh.examples.integration.core.xml.handler.GlobalErrorHandler
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.ImportResource

/**
 * Created by Farrukhjon SATTOROV.
 */
@Configuration
@EnableAutoConfiguration
@ImportResource('classpath:META-INF/spring/integration/error-handler-application-context.xml')
class ErrorHandlerApplicationConfiguration {

    @Bean
    GlobalErrorHandler globalErrorHandler() {
        new GlobalErrorHandler()
    }
}
