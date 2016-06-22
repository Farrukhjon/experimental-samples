package org.examples.operators.object

import org.examples.pojo.GPerson

// safe navigation operator used to void NullPointerException
class SafeNavigationOperator {

	static main(args){
		def person = new GPerson()
		def name = person?.name
		assert name == null
	}
}
