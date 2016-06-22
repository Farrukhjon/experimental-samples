package org.farrukh.examples.spock.core

import spock.lang.Specification
import spock.lang.Unroll

class MethodUnrollTestDemo extends Specification {

	@Unroll
	def "maximum of two numbers success test"(int a, int b, int c) {
		expect:
		
		Math.max(a, b) == c
		where:
		a|b|c
		1|2|2
		3|3|3
		4|3|4
	}
}
