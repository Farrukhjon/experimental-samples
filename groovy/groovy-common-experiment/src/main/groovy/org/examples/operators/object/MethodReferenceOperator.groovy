package org.examples.operators.object

class MethodReferenceOperator {

	static main(args) {
		def str = 'example of method reference'
		
		def upperCaseFunction = str.&toUpperCase
		def upper = upperCaseFunction()
		
		assert upper == str.toUpperCase()
	}
}
