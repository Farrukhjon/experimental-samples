package org.examples.closure

class DefinationsOfClosure {

	def printer = {
		line = '\n' -> print line
	}


	def static Closure getPrinter() { 
		return {line ->
			print line
		}
	}
	static main(args){
		getPrinter();
	}
}
