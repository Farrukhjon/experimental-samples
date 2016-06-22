package org.farrukh.examples.patterns.structural.composite.ch1;

public class Circle implements IGraphic {

	@Override
	public void print() {
		System.out.printf("%-7s %1s %n", Circle.class.getSimpleName(), this.hashCode());
	}

}
