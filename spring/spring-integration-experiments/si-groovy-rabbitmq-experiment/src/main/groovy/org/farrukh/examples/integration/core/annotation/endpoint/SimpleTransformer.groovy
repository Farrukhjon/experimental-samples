package org.farrukh.examples.integration.core.annotation.endpoint

import org.springframework.integration.annotation.MessageEndpoint
import org.springframework.integration.annotation.Transformer

/**
 * Created by Farrukhjon SATTOROV.
 */
@MessageEndpoint
class SimpleTransformer {

    @Transformer(inputChannel = 'transformInputChannel')
    void transform() {
        1/0
    }
}
