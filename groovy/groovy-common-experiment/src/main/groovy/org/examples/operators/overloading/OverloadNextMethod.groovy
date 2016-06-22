package org.examples.operators.overloading

import groovy.transform.ToString

class OverloadNextMethod {

	static class RandomValue {
		
		private def value
		private Random randomGen = new Random()

		def next() {
			this.value = randomGen.nextInt()
		}

		RandomValue() {
			this.value = randomGen.nextInt()
		}

		def String toString() {
			"${this.value}"
		}
	}

	static main(args) {
		def r = new RandomValue()
		println(r)
		r++
		println(r)
	}
}
