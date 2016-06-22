package org.examples.classes

import groovy.transform.Immutable;

@Immutable
class ImmutablePerson {

	String name
	Integer age

	static main(args){
		def imPerson = new ImmutablePerson(name : "Vali", age:25)
	}
}
