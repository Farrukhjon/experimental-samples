package org.farrukh.examples.patterns.behavioral.iterator;

public interface Iterator {
	public Animal nextAnimal();

	public boolean isLastAnimal();

	public Animal currentAnimal();
}
