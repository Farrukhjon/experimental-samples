package org.farrukh.examples.spock.core.service

/**
 * Created by Farrukhjon on 5/29/15.
 */
class GreetingImpl implements IGreeting {

    @Override
    String sayHello(String name) {
        return 'Hello ${name}'
    }
}
