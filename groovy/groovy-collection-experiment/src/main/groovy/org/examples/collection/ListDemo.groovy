package org.examples.collection

class ListDemo {

	public ListDemo() {
		// TODO Auto-generated constructor stub
	}

	static main(args) {
		def nums = [1, 2, 3, 4];
		assert nums instanceof List
		assert nums.size() == 1;
	}
}
