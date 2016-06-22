package org.farrukh.examples.groovy.core

/**
 * Created by Farrukhjon SATTOROV.
 */
class ConvertationsInAction {
    public static void main(String[] args) {
        def ASCIIRange = 0..127
        def hexes = []
        def chars = []
        def tab = []
        ASCIIRange.each {
            hexes << Integer.toHexString(it)
            chars << (char) it.intValue()
        }
        tab << hexes
        tab << chars
        println tab

        def hexRange = '0'..'7f'

        hexRange.each {
            it
            println it
        }
    }
}
