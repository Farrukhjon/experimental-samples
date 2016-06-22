package org.farrukh.examples.patterns.structural.composite.ch1;

public class Ellipse implements IGraphic {

	@Override
	public void print() {
		System.out.printf("%-7s %1s %n", this.getClass().getSimpleName(), this.hashCode());
	}
}
