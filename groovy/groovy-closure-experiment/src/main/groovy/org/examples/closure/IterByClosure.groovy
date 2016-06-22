package org.examples.closure

class IterByClosure {

	static main(args) {

		def list = [0, 1, 2, 3, 4, 5]

		// iter by defined count variable

		list.each { count ->
			def log = ' '
			log += count
			print log
		}
		println ''
		// iter by it 'magic' variable
		list.each { println it }

		def log = ''
		(0..10).each({ log += it })
		assert log == '012345678910'

	}
}
