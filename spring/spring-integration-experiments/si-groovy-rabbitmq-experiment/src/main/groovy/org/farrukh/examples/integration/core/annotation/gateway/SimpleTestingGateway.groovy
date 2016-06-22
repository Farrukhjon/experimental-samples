package org.farrukh.examples.integration.core.annotation.gateway

import org.springframework.integration.annotation.MessagingGateway

/**
 * Created by Farrukhjon SATTOROV.
 */
@MessagingGateway(name = 'testingGateway', defaultRequestChannel = 'transformInputChannel', errorChannel = 'errorChannel')
interface SimpleTestingGateway {

    void process(String message)
}