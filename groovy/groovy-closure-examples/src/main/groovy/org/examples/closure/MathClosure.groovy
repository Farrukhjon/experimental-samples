package org.examples.closure

class MathClosure {

	def add = {x, y -> x + y}
	def mul = {x,y -> x *y }

	def subtract(x, y) {return x - y} // just function
	def div = { x, y -> x/y}


	static main(args){
		MathClosure f = new MathClosure()
		assert (f.add instanceof java.lang.Object) == true
		assert (f.div instanceof Closure) == true
		assert f.add(1, 2) == 3
		assert f.mul(2,3) == 6
		assert f.div(1, 2) == 0.5
		assert f.subtract(2, 1) == 1
	}
}
