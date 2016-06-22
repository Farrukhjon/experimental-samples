package org.farrukh.examples.spock.core.ddt

import spock.lang.Specification
import spock.lang.Unroll

class DataPipesTestDemo extends Specification {

	@Unroll
	def 'maximum of two numbers success test'(int a, int b, int c) {
		expect:
		Math.max(a, b) == c

		where:
		a << [1, 2, 2] //data pipes
		b << [0, 4, 4]
		c << [1, 4, 4]
	}

}
