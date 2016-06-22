package org.farrukh.examples.java.generic.collections;

public class Cat extends Animal {

	private String name;
	
	public Cat(String name) {
		this.name = name;
	}

	@Override
	public void eat() {
		System.out.println("Naym nyam");
	}
	
	@Override
	public String toString() {
		return name;
	}
}
