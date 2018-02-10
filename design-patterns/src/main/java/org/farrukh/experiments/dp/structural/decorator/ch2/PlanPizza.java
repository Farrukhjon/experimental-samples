package org.farrukh.experiments.dp.structural.decorator.ch2;

public class PlanPizza implements IPizza {

	@Override
	public String getDescriptin() {
		return "Thin Dough";
	}

	@Override
	public double getCost() {
		return 40.00;
	}

}
