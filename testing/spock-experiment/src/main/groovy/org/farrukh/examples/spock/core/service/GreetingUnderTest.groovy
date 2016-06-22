package org.farrukh.examples.spock.core.service

import groovy.transform.Canonical

/**
 * Created by Farrukhjon on 5/29/15.
 */
@Canonical
class GreetingUnderTest {

    IGreeting greeting

    String sayHello(String name) {
        greeting.sayHello(name)
    }

    String sayDoubleHello(String name) {
        greeting.sayHello(name)
        greeting.sayHello(name)
    }

}
