/**
 * 
 */
package org.farrukh.examples.spock.core.interactions

import org.farrukh.examples.spock.core.service.Subscriber

import spock.lang.Specification

/**
 * @author Farrukhjon SATTOROV
 *
 */
class SubscriberPublisherStubbingDemo extends Specification {

	def sub1 = Stub(Subscriber)
	def sub2 = Stub(Subscriber)

	def 'should delivers messages to all subscribers'(){
		when:
		sub2.receive('bad')
		sub1.receive(!null) >> 'I have got a greeting message'
		
		def r = sub1.receive('blah')

		then:
		r == 'I have got a greeting message'
		//sub1.receive(_ as String) >> ""
		sub2.receive(!null) >> 'I have not a greeting message'
	}
}
