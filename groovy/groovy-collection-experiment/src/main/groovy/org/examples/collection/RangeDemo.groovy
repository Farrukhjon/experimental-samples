package org.examples.collection


class RangeDemo {

	static main(args) {
		assert (0..10).contains(0)
		assert (0..10).contains(5)
		assert (0..10).contains(10)
		assert (0..10).contains(-1) == false
		assert (0..10).contains(11) == false

		assert (0..<10).contains(9)
		assert (0..<10).contains(10) == false

		def range = 0..10
		assert range instanceof Range // Ranges are objects
		assert range.contains(5) == true

		for(element in 0..5){
			print element
		}
		
		
	}
}
