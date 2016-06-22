package org.examples.operators.bitwise

class PredefineLeftShifOperator {

	String name

	public String leftShift(PredefineLeftShifOperator other){
		name << other.name
	}

	static main(args) {
		def obj1 = new PredefineLeftShifOperator(name:"Hello")
		def obj2 = new PredefineLeftShifOperator(name:" world")
		
		assert obj1 << obj2 == "Hello world" // like obj1.leftShift(obj2) == "Hello world"
	}
}
