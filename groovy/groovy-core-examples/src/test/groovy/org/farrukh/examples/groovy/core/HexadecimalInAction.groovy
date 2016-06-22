package org.farrukh.examples.groovy.core

import spock.lang.Specification

/**
 * Created by Farrukhjon SATTOROV.
 */
class HexadecimalInAction extends Specification {

    def 'exercise integer literals for equality'() {
        given:
        int decimaLiteral = 127
        int heximalLiteral = 0x7f
        int binaryLiteral = 0b1111111

        expect:
        decimaLiteral == heximalLiteral
        decimaLiteral == binaryLiteral
        heximalLiteral == binaryLiteral
    }

    def 'hex literals'() {

        given:
        def values = 0x10000..0x10FFFF
        def strs = []

        when:
        values.each {
           strs << it.toString()
            Integer.parseInt(it.toString(), 16)
        }

        then:
        strs
    }

    def 'hex to chars in ASCII'() {
        given:
        def ASCIIInHex = 0..7F

        def charsList = []
        when:
        ASCIIInHex.every {
            def hexString = Integer.toHexString(it)
            charsList << Integer.parseInt(hexString, 16) as char
        }

        then:
        charsList
    }

    def 'convert string to hex'() {
        given:
        def greeting = 'Hello world'

        when:
        def chars = greeting.toCharArray()
        def hexes = []
        chars.each {
            hexes << Integer.toHexString(it as int)
        }

        and:
        def hexString = hexes.join('')

        then:
        hexes
        hexString
    }




}
