package org.farrukh.examples.groovy.core

import spock.lang.Specification

/**
 * Created by Farrukhjon SATTOROV.
 */
class StringInAction extends Specification {

    def 'exercise splitting string to collection'() {
        given: 'a proper string'
        def sentence = 'This is a simple sentence'

        and: 'expected value'
        def expected = ['This', 'is', 'a', 'simple', 'sentence']

        when: 'the sentence is slitted to array and converted list'
        def result = sentence.split(' ') as List

        then: 'expected value is returned'
        result == expected
    }

    def 'exercise replacing a character to upper case'() {
        given:
        def greeting = 'Hello world!'

        and:
        def expected = 'hello world!'
        def firstChar = greeting.charAt(0)

        when:
        def result = greeting.replace(firstChar, firstChar.toLowerCase())

        then:
        result == expected
    }
}
