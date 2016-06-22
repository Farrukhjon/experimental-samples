package org.farrukh.examples.spock.core.ddt

import spock.lang.Specification

class DataTableTestsDemo extends Specification {

	def "maximum of two numbers success test"(int a, int b, int c) {
		expect:
		Math.max(a, b) == c
		
		where:
		a|b|c
		1|2|2
		3|3|3
		4|3|4
	}

    def "exercise maximum by Syntactic Variation "() {
		expect:
		Math.max(a, b) == c

		where:
		a|b|c
		1|2|2
		3|3|3
		4|3|4
	}

}
