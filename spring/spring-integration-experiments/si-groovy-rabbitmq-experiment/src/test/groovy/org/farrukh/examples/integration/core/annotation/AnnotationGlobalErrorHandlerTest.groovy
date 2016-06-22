package org.farrukh.examples.integration.core.annotation

import org.farrukh.examples.integration.core.annotation.configuration.ErrorHandlerConfiguration
import org.farrukh.examples.integration.core.annotation.gateway.SimpleTestingGateway
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 * Created by Farrukhjon SATTOROV.
 */
@ContextConfiguration(classes = ErrorHandlerConfiguration, loader = SpringApplicationContextLoader)
class AnnotationGlobalErrorHandlerTest extends Specification {

    @Autowired
    SimpleTestingGateway testingGateway

    def 'exercise global error handler'() {
        given: 'a valid message'
        def payload = 'Hello world'

        when:
        testingGateway.process(payload)

        then:
        true
    }
}
