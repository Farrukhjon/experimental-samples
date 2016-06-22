/**
 * 
 */
package org.examples.closure

/**
 * @author Farrukhjon SATTOROV
 *
 */
class ClosureParameterDemo {

	def static closure = { println 'empty param' }
	
	def static closureParamInPlaceholder = { param -> println "Hello ${param}" }
	
	def static closureParam = { param -> println param }

	def static closureMultiParam = { param1, param2, param3  ->
		println param1 + param2 + param3
	}

	static main(args) {
		closure()
		closureParamInPlaceholder("the param");
		closureParam("one param")
		closureMultiParam("first param ", "second param ", "third param")
	}
}
