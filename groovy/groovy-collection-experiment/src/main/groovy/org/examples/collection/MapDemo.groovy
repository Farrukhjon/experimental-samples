package org.examples.collection

class MapDemo {

	static main(args) {
		def map = ['a':1, 'b':2, 'c':3]
		map.putAt("d", 4)
		println map
	}
}
