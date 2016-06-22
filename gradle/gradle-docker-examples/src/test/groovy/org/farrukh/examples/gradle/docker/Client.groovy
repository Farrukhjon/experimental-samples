package org.farrukh.examples.gradle.docker

import spock.lang.Specification

/**
 * Created by Farrukhjon on 6/11/15.
 */
class Client extends Specification {

    def 'exercise send request to the server'() {
        given:
        def socket = new Socket('localhost', 2020)

        when:
        def response = socket.withStreams { input, output ->
            output << 'echo testing ...\n'
            def buffer = input.newReader().readLine()
            println "response: $buffer"
            buffer
        }
        then:
        response
    }
}
