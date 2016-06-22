package org.farrukh.examples.java.core

import spock.lang.Specification

class StringBuilderTests extends Specification {

    StringBuilder sut;

    def setup() {
        sut = new StringBuilder()
    }

    def 'should insert a string at the end of the builder'() {
        given:
        def someString = 'abc'

        when:
        sut.append(someString)
        sut.append('z')

        and:
        def result = sut.toString()

        then:
        result == 'abcz'
        sut.indexOf('z') == 3
    }

}
