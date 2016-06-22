package org.farrukh.examples.patterns.structural.decorator.ch2;

public class ToppingDecorator implements IPizza {

	private IPizza	pizza;

	public ToppingDecorator(IPizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public String getDescriptin() {
		return pizza.getDescriptin();
	}

	@Override
	public double getCost() {
		return pizza.getCost();
	}

}
