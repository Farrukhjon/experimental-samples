package org.examples.closure

class TestTwoTypeDefOfClosure {
	
	def static closure = {}

	static Closure closure1 = {}

	static main(args) {
		assert (closure instanceof Closure) == true
		assert (closure1 instanceof Closure) == true
	}
}
