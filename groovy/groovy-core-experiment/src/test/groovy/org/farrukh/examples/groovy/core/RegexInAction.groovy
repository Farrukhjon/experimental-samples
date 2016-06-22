package org.farrukh.examples.groovy.core

import spock.lang.Specification

/**
 * Created by Farrukhjon SATTOROV.
 */
class RegexInAction extends Specification {

    def 'exercise match operator'() {
        given:
        def someText = 'some text to match'

        when:
        def matcher = someText ==~ 'some text'

        then:
        matcher instanceof Boolean
    }

    def 'exercise making java.util.regex.Pattern'() {
        when:
        java.util.regex.Pattern wordPattern = ~/\w/ // ~string is a pattern operator

        then:
        wordPattern
    }

    def 'exercise making a java.util.regex.Matcher'() {
        when:
        java.util.regex.Matcher digitMatcher = '123' =~ /\d/ //

        then:
        digitMatcher
    }

    def 'exercise word matcher by slashy regex'() {
        given:
        def greeting = 'Hello worlds'

        when:
        def matches = greeting.matches(/(\w+)/)

        then:
        matches
    }

    def 'exercise replacing dots in the string'() {
        given:
        def dottedGreeting = 'hello.world'

        when:
        def result = dottedGreeting.replaceAll(/\./, ' ')

        then:
        result == 'hello world'
    }

    def 'exercise extracting a data which matches to a regex'() {
        given:
        def dottedGreeting = 'hello.data'

        when:
        def pattern = ~/(\.\w+)/
        def matcher = pattern.matcher(dottedGreeting)
        def value
        if (matcher.find()) {
            value = matcher.group(1)
        }

        then:
        value == '.data'
    }


}
