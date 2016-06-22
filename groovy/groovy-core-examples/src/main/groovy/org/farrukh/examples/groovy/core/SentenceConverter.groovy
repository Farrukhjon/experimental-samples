package org.farrukh.examples.groovy.core

/**
 * Created by Farrukhjon SATTOROV.
 */
class SentenceConverter {

    String toCamelCase(String dotSentence) {
        def temp = []
        dotSentence.split(/\./).eachWithIndex { it, index ->
            if (index) {
                def firstChar = it[0]
                temp << it.replace(firstChar, firstChar.toUpperCase())
            } else {
                temp << it.toLowerCase()
            }
        }
        temp.join('')
    }

    String toCamelCase2(String dotSentence) {
        def result = dotSentence.split(/\./).each {
            it.substring(0, 1) == it.substring(0, 1).toUpperCase()
            it
        }.join('')
        result
    }

    String toCamelCase3(String dotSentence) {
        dotSentence.replaceAll(/(\.\w)/) { it
            it[0].substring(1, 2).toUpperCase()
        }
    }

    String toCamelCase4(String dotSentence) {
        dotSentence.replaceAll(/\.\w/) { String match ->
            match[1].toUpperCase()
        }
    }


}