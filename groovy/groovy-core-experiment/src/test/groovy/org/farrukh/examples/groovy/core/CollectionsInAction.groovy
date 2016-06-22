package org.farrukh.examples.groovy.core

import spock.lang.Specification

/**
 * Created by Farrukhjon SATTOROV.
 */
class CollectionsInAction extends Specification {

    def 'exercise a list sorting'() {
        given: 'unsorted numbers'
        def numbers = [4, 1, 3, 0, 9, 8, 5]

        and:
        def expected = [0, 1, 3, 4, 5, 8, 9 ]

        when:
        def result = numbers.sort()

        then:
        result == expected
    }

    def 'exercise doubling a list by collecting'() {
        given: 'numbers for doubling'
        def numbers = [4, 1, 3, 0, 9, 8, 5]

        and: 'expected list'
        def expected = [8, 2, 6, 0, 18, 16, 10]

        when: 'collect with closure is called'
        def result = numbers.collect {
            it * 2
        }

        then: 'expected list is returned'
        result == expected
    }

    def 'exercise summing a doubled list by collecting and sum'() {
        given: 'numbers for doubling'
        def numbers = [4, 1, 3, 0, 9, 8, 5]

        and: 'expected value'
        def expected = 60

        when: 'collect with closure is called and summed'
        def result = numbers.collect {
            it * 2
        }.sum()

        then: 'expected value is returned'
        result == expected
    }

    def 'exercise flatten a list'() {
        given: 'a matrices NxN'
        def matrices = [[1, 2, 3], [], [4, 5, 6,], [7, 8, 9 ]]

        and:
        def expectedNumbers = [1, 2, 3, 4, 5, 6, 7, 8, 9]

        when: 'on matrices flatten is called'
        def result = matrices.flatten()

        then: 'expected list is returned'
        result == expectedNumbers
    }

    def 'exercise alphabet using ranges'() {
        given:
        def alphaBet = 'a'..'z'

        when:
        def upperAlphaBet = alphaBet.collect {
            it.toUpperCase()
        }

        then:
        upperAlphaBet == 'A'..'Z' as List

    }

}
