package org.examples.pojo

class GPersonDemo {

	Integer id
	String name
	Date dob

	static main(args) {
		def ali = new GPerson(id:1, name:'Ali', dob: new Date())
		println("Hello ${ali.name}")

		def vali = new GPerson()
		vali.setId(2)
		vali.setName("Vali")
		vali.setDob(new Date())
		
		println("Hello ${vali.name}")
	}
}
