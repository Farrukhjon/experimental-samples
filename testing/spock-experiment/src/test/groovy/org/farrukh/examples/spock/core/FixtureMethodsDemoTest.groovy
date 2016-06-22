package org.farrukh.examples.spock.core

import spock.lang.Specification

class FixtureMethodsDemoTest extends Specification {

    def setup() {
        println "setup..."
    }

    def setupSpec() {
        println "setupSpec..."
    }

    def cleanup() {
        println "cleanup..."
    }

    def cleanupSpec() {
        println "cleanupSpec..."
    }

    def 'test1'() {
        when:
        println "Teting1..."

        then:
        true
    }

    def 'test2'() {
        when:
        println "Teting2..."

        then:
        true
    }

    def 'test3'() {
        when:
        println "Teting3..."

        then:
        true
    }

}
