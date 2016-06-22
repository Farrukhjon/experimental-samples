package org.farrukh.examples.spring.integration.rabbitmq

import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 * Created by Farrukhjon SATTOROV.
 */
@ContextConfiguration(classes = Application, loader = SpringApplicationContextLoader)
class AbstractBaseIntegrationTest extends Specification {


}
