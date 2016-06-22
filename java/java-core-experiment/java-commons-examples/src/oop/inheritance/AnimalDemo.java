package oop.inheritance;

public class AnimalDemo {

	public static void main(String[] args) {

		Cat cat = new Cat();
		Dog dog = new Dog();

		System.out.println(cat.weight);
		System.out.println(dog.weight);

		Animal animal = new Animal() {
			
		};
		System.out.println(animal.weight);
	}
}
