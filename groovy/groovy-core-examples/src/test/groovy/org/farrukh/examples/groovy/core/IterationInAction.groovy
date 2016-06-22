package org.farrukh.examples.groovy.core

import spock.lang.Specification

/**
 * Created by Farrukhjon SATTOROV.
 */
class IterationInAction extends Specification {

    def 'exercise iteration over POGO properties'() {

        given: 'person as subject under test'
        def person = new Person(firstName: 'Aliev', name: 'Vali', lastName: 'Samievich', age: 30)

        and: 'expectations have been created'
        def expectedValues = []
        def expectedKeys = []
        def expectedStrings = []
        def expectedIntegers = []

        when: 'iterating over properties of the person'
        person.properties.each { key, value ->
            expectedKeys << key
            expectedValues << value
            if (value instanceof String) {
                expectedStrings << value
            }
            if (value instanceof Integer) {
                expectedIntegers << value
            }
        }

        then: 'expected results are returned'
        expectedKeys == ['class', 'firstName', 'lastName', 'age', 'name']
        expectedValues == [Person, 'Aliev', 'Samievich', 30, 'Vali']
        expectedStrings == ['Aliev', 'Samievich', 'Vali']
        expectedIntegers == [30]
    }


}
