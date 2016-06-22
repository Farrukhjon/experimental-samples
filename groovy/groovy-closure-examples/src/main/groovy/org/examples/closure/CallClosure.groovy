/**
 * 
 */
package org.examples.closure

/**
 * @author Farrukhjon SATTOROV
 *
 */
class CallClosure {

	static def myclosure = { print 'call closure using call() method' }

	static main(args) {
		myclosure.call()
	}
}
