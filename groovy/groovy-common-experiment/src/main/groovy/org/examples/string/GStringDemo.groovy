package org.examples.string

class GStringDemo {

	static main(args) {
		def name = "Ali" // dynamoc typing
		String patronymic = "Valiev" // static typing
		GString result = "Name is ${name} and patronymic is ${patronymic}" // static GString typing
		print result
		assert (name instanceof String) == true
		assert (result instanceof GString) == true
	}
}
