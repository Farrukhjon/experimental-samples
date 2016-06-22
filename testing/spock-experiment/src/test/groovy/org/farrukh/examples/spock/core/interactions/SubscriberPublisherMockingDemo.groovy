/**
 * 
 */
package org.farrukh.examples.spock.core.interactions

import org.farrukh.examples.spock.core.service.Publisher
import org.farrukh.examples.spock.core.service.Subscriber

import spock.lang.Specification

/**
 * @author Farrukhjon SATTOROV
 *
 */
class SubscriberPublisherMockingDemo extends Specification {

	def sut = new Publisher()

	def sub1 = Mock(Subscriber)
	def sub2 = Mock(Subscriber)

	def setup() {
		sut.subscribers << sub1 << sub2
	}

	def 'should delivers messages to all subscribers'() {
		when:
		sut.send('hello world')

		then:
		1 * sub1.receive('hello world')
		1 * sub2.receive('hello world')
	}

}
