package org.farrukh.examples.spock.core.ddt

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by Farrukhjon on 6/8/15.
 */
class ParametrizedTests extends Specification {

    @Unroll("Math.pow(#base, 2) == #expectedResult")
    def 'this will run three tests'() {
        expect:
        Math.pow(base, 2) == expectedResult

        where:
        base || expectedResult
        2    || 4
        3    || 9
        10   || 100
    }

    @Unroll
    def "this will run three tests2"() {
        expect:
        Math.pow(base, 2) == expectedResult

        where:
        base | expectedResult
        2    | 4
        3    | 9
        10   | 100
    }

    @Unroll('#a + #b = #result')
    def 'exercise parametrization test'() {
        when:
        result = Math.addExact(a, b)

        then:
        result

        where:
        a  | b  || result
        1  | 1  || 2
        1  | 0  || 1
        1  | 3  || 4
        5  | -1 || 4
        -1 | 2  || 1
    }
}
