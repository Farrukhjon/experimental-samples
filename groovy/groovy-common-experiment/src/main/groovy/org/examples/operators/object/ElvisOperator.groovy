package org.examples.operators.object

class ElvisOperator {

	static main(args) {
		def a = null
		def b = a?:true

		assert b == true
	}
}
