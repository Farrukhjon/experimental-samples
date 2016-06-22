package org.farrukh.examples.patterns.structural.decorator.ch2;

public class Client {

	public static void main(String[] args) {

		IPizza basicPizza = new Cheese(new TomatoSauce(new Mozarella(new PlanPizza())));
		System.out.println("Ingredients: " + basicPizza.getDescriptin());
		System.out.println("Price: " + basicPizza.getCost());

	}
}
