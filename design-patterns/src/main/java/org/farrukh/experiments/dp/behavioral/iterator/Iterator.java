package org.farrukh.experiments.dp.behavioral.iterator;

public interface Iterator {
	public Animal nextAnimal();

	public boolean isLastAnimal();

	public Animal currentAnimal();
}
