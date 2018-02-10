package org.farrukh.experiments.dp.structural.decorator.ch3;

public class DarkRoast extends Beverage {
	
	public DarkRoast() {
		description = "Dark roast";
	}
	
	@Override
	public double cost() {
		return 1.32;
	}

}
