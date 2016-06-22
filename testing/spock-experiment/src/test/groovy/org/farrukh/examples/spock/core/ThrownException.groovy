package org.farrukh.examples.spock.core

import spock.lang.Specification

/**
 * Created by Farrukhjon on 6/8/15.
 */
class ThrownException extends Specification {

    static class Calculator {
        double div(a, b) {
            if (b == 0) {
                throw new ArithmeticException();
            }
            a / b
        }
    }

    def 'exercise just throws an exception'() {
        given:
        def sut = new Calculator()
        when:
        sut.div(1, 0)

        then:
        thrown(ArithmeticException)
    }
}
