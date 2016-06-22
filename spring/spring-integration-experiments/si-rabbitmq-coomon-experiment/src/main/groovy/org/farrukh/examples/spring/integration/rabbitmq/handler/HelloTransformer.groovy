package org.farrukh.examples.spring.integration.rabbitmq.handler

import groovy.util.logging.Slf4j
import org.springframework.integration.annotation.Transformer

/**
 * Created by Farrukhjon SATTOROV.
 */
@Slf4j
class HelloTransformer {

    @Transformer
    String transform(String message) {
        log.info('The message {} has been transformed!', message)
        message.toUpperCase()
    }
}
