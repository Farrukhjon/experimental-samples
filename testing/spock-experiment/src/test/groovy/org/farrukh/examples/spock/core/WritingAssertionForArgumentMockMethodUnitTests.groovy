package org.farrukh.examples.spock.core

import org.farrukh.examples.spock.core.service.GreetingUnderTest
import org.farrukh.examples.spock.core.service.IGreeting
import spock.lang.Specification

/**
 * Created by Farrukhjon on 5/29/15.
 */
class WritingAssertionForArgumentMockMethodUnitTests extends Specification {

    def greeting = Mock(IGreeting)
    def sut = new GreetingUnderTest(greeting: greeting)

    def 'exercise single call greeting'() {
        when:
        sut.sayHello('wold')

        then:
        1 * greeting.sayHello('wold') >> 'world'
    }

    def 'exercise double call greeting'() {
        when:
        sut.sayDoubleHello('wold')

        then:
        2 * greeting.sayHello('wold') >> 'world'
    }


}
