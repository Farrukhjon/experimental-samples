package org.farrukh.examples.spring.mvc.content.negotiation

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.boot.test.WebIntegrationTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

/**
 * Created by Farrukhjon on 5/19/2015.
 */
@ContextConfiguration(classes = Application, loader = SpringApplicationContextLoader)
@WebIntegrationTest('server.port:0')
class BaseIntegrationTest extends Specification {

    @Autowired
    RestTemplate restTemplate

    @Value('${local.server.port}')
    int port
}
