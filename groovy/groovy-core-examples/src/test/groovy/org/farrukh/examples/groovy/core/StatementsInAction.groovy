package org.farrukh.examples.groovy.core

import spock.lang.Specification

/**
 * Created by Farrukhjon SATTOROV.
 */
class StatementsInAction extends Specification {

    def 'exercise multiple assignment'() {
        given:
        def (a, b, c) = [10, 1.1, 'foo']

        expect:
        a == 10
        b == 1.1
        c == 'foo'
    }

    def 'exercise multiple assignment from existing variable'() {
        given:
        def numbers = [1, 2, 3]
        def (a, b, c) = numbers

        expect:
        a == 1
        b == 2
        c == 3
    }
}
