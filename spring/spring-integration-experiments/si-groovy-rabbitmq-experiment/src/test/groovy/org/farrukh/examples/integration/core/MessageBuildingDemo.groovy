package org.farrukh.examples.integration.core

import org.springframework.integration.support.MessageBuilder
import spock.lang.Specification

/**
 * Created by Farrukhjon SATTOROV.
 */
class MessageBuildingDemo extends Specification {

    def 'exercise building message by default headers'() {
        given: 'a string message payload'
        def payload = 'Hello world!'

        when: 'the amqp message is created'
        def message = MessageBuilder.withPayload(payload).build()

        then: 'expected values are returned'
        message
        message.payload == payload
        message.headers['id']
        message.headers['timestamp']
    }

    def 'exercise building message with custom headers'() {
        given: 'a string message payload'
        def payload = 'Hello world!'

        and: 'header names constants'
        def CONTENT_TYPE_NAME = 'content_type'
        def APP_ID_NAME = 'app_id'

        and: 'header values constants'
        def content_type_value = 'plain/text'
        def app_id_value = UUID.randomUUID().toString()

        when: 'the message is created'
        def message = MessageBuilder.withPayload(payload)
                .setHeader(CONTENT_TYPE_NAME, content_type_value)
                .setHeader(APP_ID_NAME, app_id_value)
                .build()

        then: 'expected values are returned'
        message
        message.payload == payload
        message.headers[CONTENT_TYPE_NAME] == content_type_value
        message.headers[APP_ID_NAME] == app_id_value
    }


}
