package org.examples.converting

class ConvertingByMethods {

	static main(args){
		def x = '1'
		assert (x instanceof String) == true
		def i = x.toInteger()
		assert (i instanceof Integer) == true
	}
}
