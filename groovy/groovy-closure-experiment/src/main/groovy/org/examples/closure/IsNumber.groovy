package org.examples.closure

class IsNumber extends Closure<Boolean> {

	IsNumber(){
		super(null);
	}

	Boolean doCall(final Object value){
		value in Number
	}

	static main(args){
		def list = ['a', 100, 'Groovy', 1, 2, 3, true, 4, 5, false]
		def numbers = list.findAll (new IsNumber())
		assert numbers == [100, 1, 2, 3, 4, 5]
	}
}