package org.farrukh.examples.integration.core.xml

import org.farrukh.examples.integration.core.xml.configuration.ErrorHandlerApplicationConfiguration
import org.farrukh.examples.integration.core.xml.service.TestingGateway
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 * Created by Farrukhjon SATTOROV.
 */
@ContextConfiguration(classes = ErrorHandlerApplicationConfiguration, loader = SpringApplicationContextLoader)
class GlobalErrorHandlerTest extends Specification {

    @Autowired
    TestingGateway testingGateway

    def 'exercise global error handler'() {
        given: 'a valid message'
        def payload = 'Hello world'

        when:
        testingGateway.process(payload)

        then:
        true
    }
}
