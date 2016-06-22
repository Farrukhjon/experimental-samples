package org.farrukh.examples.groovy.core

import spock.lang.Specification

/**
 * Created by Farrukhjon SATTOROV.
 */
class CharacterInAction extends Specification {

    def 'exercise happy unicode char validation'() {
        given:
        def uniCodeRange = 0x0000..0x10FFFF

        expect:
        uniCodeRange.every {
            Character.isValidCodePoint(it)
        }

    }

    def 'exercise said unicode char validation'() {
        given:
        def codePoint = 43736 //'\uAAD8'

        expect:
        Character.isSupplementaryCodePoint(codePoint)
    }
}
