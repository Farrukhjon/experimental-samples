package org.farrukh.examples.groovy.core

import spock.lang.Specification

/**
 * Created by Farrukhjon SATTOROV.
 */
class ClassesInAction extends Specification {

    def 'exercise numbers class name'() {
        expect:
        1.class.name == 'java.lang.Integer'
        1738274834738.class.name == 'java.lang.Long'
        (0.1).class.name == 'java.math.BigDecimal'
    }

    def 'exercise collections class name'() {
        expect:
        [].class.name == 'java.util.ArrayList'
        [:].getClass().name == 'java.util.LinkedHashMap'
    }

    def 'exercise collections class name after casting'() {
        given:
        def aLinkedList = [1, 2, 3] as LinkedList
        def aSet = [1, 4, 2, 6, 4,] as Set

        expect:
        aLinkedList.class.name == 'java.util.LinkedList'
        aSet.class.name == 'java.util.LinkedHashSet'
    }

}
