package org.farrukh.examples.patterns.behavioral.iterator;

import java.util.List;

public interface IZoo {

	public List<Animal> getAnimals();

	public void addAnimal(Animal animal);

	public void removeAnimal(Animal animal);

	public Iterator createIterator(String iteratorType);
}
