package org.examples.converting

class ConvertingByKeyword {

	static main(args) {
		def x = '1'
		assert ((x as Integer) instanceof Integer) == true
	}
}
