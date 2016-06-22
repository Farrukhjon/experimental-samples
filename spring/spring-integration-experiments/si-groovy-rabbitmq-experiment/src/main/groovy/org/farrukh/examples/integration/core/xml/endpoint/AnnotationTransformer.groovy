package org.farrukh.examples.integration.core.xml.endpoint

import org.springframework.integration.annotation.Transformer

/**
 * Created by Farrukhjon SATTOROV.
 */
class AnnotationTransformer {

    @Transformer(inputChannel = 'transformInputChannel')
    void transform() {
        1/0
    }
}
