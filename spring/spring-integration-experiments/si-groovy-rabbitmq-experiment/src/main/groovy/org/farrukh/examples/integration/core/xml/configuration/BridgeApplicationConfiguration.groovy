package org.farrukh.examples.integration.core.xml.configuration

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.ImportResource

/**
 * Created by Farrukhjon SATTOROV.
 */
@Configuration
@EnableAutoConfiguration
@ImportResource('classpath:META-INF/spring/integration/bridge-application-context.xml')
class BridgeApplicationConfiguration {
}
