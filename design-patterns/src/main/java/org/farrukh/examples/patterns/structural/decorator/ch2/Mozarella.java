package org.farrukh.examples.patterns.structural.decorator.ch2;

public class Mozarella extends ToppingDecorator {

	public Mozarella(IPizza tempPizza) {
		super(tempPizza);
		System.out.println("Adding dough");
		System.out.println("Adding moz");
	}

	@Override
	public String getDescriptin() {
		return super.getDescriptin() + ", Mozzarella, ";
	}

	@Override
	public double getCost() {
		return super.getCost() + 0.52;
	}

}
