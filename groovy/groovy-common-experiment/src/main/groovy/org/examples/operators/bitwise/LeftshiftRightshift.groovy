package org.examples.operators.bitwise;

class LeftshiftRightshift {



	static main(args){

		def a = 10
		def b = 2

		def c = a << b
		println c

		def d = a.rightShift(b)
		println d

		def x = [1, 2, 3]<< 3
		println x

		def y = [4, 5, 6].leftShift(3)
		println y

		def z = [7, 8, 9]<< 10
		assert z == [7, 8, 9, 10]
	}
}