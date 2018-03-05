package org.farrukh.examples.java.generic.collections;

import java.util.ArrayList;
import java.util.List;

public class TestGenParams {

	public static void main(String[] args) {

		List<Animal> animalList0 = new ArrayList<Animal>();
		
		animalList0.add(new Dog("Tarzan"));
		animalList0.add(new Dog("Sharik"));
		animalList0.add(new Cat("Kisa"));

		TestGenParams ta = new TestGenParams();
		ta.takeAnimal(animalList0);
		
		for (Animal a : animalList0) {
			a.eat();
		}
		
		System.out.println(animalList0);
	}
	
	public void takeAnimal(List<Animal> animalList) {
		animalList.add(new Cat("Misa"));
	}

}
