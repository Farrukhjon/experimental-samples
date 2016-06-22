package org.farrukh.examples.spock.core

import spock.lang.Specification

/**
 * Created by Farrukhjon SATTOROV.
 */
class WithMethodDemo extends Specification {

    class Person {
        int id
        String firstName
        String lastName
    }

    def 'exercise using with(object) method for testing fields'() {
        given: 'a proper object'
        def person = new Person(id: 1, firstName: 'Ali', lastName: 'Valiev')

        expect:
        with(person) {
            id == 1
            firstName == 'Ali'
            lastName == 'Valiev'
        }
    }

    def 'exercise using object.with method for testing fields'() {
        given: 'a proper object'
        def person = new Person(id: 1, firstName: 'Ali', lastName: 'Valiev')

        expect:
        person.with {
            assert id == 1
            assert firstName == 'Ali'
            assert lastName == 'Valiev'
        }
    }
}
