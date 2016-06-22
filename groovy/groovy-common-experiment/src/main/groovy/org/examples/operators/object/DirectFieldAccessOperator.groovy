package org.examples.operators.object

import org.examples.pojo.GPerson

class DirectFieldAccessOperator {

	static main(args) {
		def person = new GPerson();
		person.setName("Ali");
		
		assert "Ali" == person.@name // direct access to name field: Person.name
									// .@ operator forces usage of the field instead of the getter
		assert person.name == person.getName() // . operator call getter
	}
	
}
