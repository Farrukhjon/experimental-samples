package org.farrukh.examples.groovy.core

import spock.lang.Specification

/**
 * Created by Farrukhjon SATTOROV.
 */
class SentenceConverterUnitTest extends Specification {
    
    def 'exercise converting dot sentence to a camelCase sentence'() {
        given:
        def sut = new SentenceConverter()

        and:
        def dotSentence = 'abc.def.ghi.jkl.mno.pqa'
        def expectedSentence = 'abcDefGhiJklMnoPqa'

        when:
        def result = sut.toCamelCase(dotSentence)

        then:
        result == expectedSentence
    }

    def 'exercise converting dot sentence to a camelCase sentence2'() {
        given:
        def sut = new SentenceConverter()

        and:
        def dotSentence = 'abc.def.ghi.jkl.mno.pqa'
        def expectedSentence = 'abcDefGhiJklMnoPqa'

        when:
        def result = sut.toCamelCase2(dotSentence)

        then:
        result == expectedSentence
    }

    def 'exercise converting dot sentence to a camelCase sentence3'() {
        given:
        def sut = new SentenceConverter()

        and:
        def dotSentence = 'abc.def.ghi.jkl.mno.pqa'
        def expectedSentence = 'abcDefGhiJklMnoPqa'

        when:
        def result = sut.toCamelCase3(dotSentence)

        then:
        result == expectedSentence
    }
    def 'exercise converting dot sentence to a camelCase sentence4'() {
        given:
        def sut = new SentenceConverter()

        and:
        def dotSentence = 'abc.def.ghi.jkl.mno.pqa'
        def expectedSentence = 'abcDefGhiJklMnoPqa'

        when:
        def result = sut.toCamelCase4(dotSentence)

        then:
        result == expectedSentence
    }
}
