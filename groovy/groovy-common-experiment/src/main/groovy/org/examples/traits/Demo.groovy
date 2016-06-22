package org.examples.traits;

class Demo {
	
	static main(args) {
		def a = new SomeSubType() as SomSuperClass
		a.hello()
	}
}