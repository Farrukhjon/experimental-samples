package org.farrukh.examples.integration.core.xml

import org.farrukh.examples.integration.core.xml.configuration.BridgeApplicationConfiguration
import org.farrukh.examples.integration.core.xml.service.TestingGateway
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.integration.channel.QueueChannel
import org.springframework.messaging.MessageHandlingException
import org.springframework.messaging.MessagingException
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import javax.annotation.Resource

/**
 * Created by Farrukhjon SATTOROV.
 */
@ContextConfiguration(classes = BridgeApplicationConfiguration, loader = SpringApplicationContextLoader)
class BridgeDemo extends Specification{

    @Autowired
    TestingGateway testingGateway

    @Resource(name='testing-channel')
    QueueChannel testingChannel;

    def 'exercise bridge component'() {
        given: 'a valid SI message'
        def payload = 'Hello world'

        when:
        testingGateway.process(payload)

        and:
        def errorMessage = testingChannel.receive(0)
        def resultPayload = ((MessagingException) errorMessage.getPayload()).getFailedMessage()
        def cause = ((MessagingException) errorMessage.getPayload()).getCause()

        then:
        errorMessage
        payload == resultPayload.payload
        cause instanceof MessageHandlingException
    }

}
