/**
 * 
 */
package org.examples.closure

/**
 * @author Farrukhjon SATTOROV
 *
 */
class ClosureAndCollections {

	static main(args) {
		iterationWithClosure1()
		iterationWithClosure2()
		iterationWithClosure3()
	}

	static void iterationWithClosure1() {
		def iterClosure = {println it }
		[0, 1, 2, 3, 4, 5, 6, 7, 8, 9].each(iterClosure)
	}

	static void iterationWithClosure2() {
		[0, 1, 2, 3, 4, 5, 6, 7, 8, 9].each({println it })
	}
	
	static void iterationWithClosure3() {
		[0, 1, 2, 3, 4, 5, 6, 7, 8, 9].each{println it }
	}
}
