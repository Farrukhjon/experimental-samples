/**
 *
 */
package org.farrukh.examples.spock.core.service
/**
 * @author Farrukhjon SATTOROV
 */
class Publisher {

    List<Subscriber> subscribers = new ArrayList<>()

    void send(String message) {
        subscribers.each {
            it.receive(message)
        }
    }

}
