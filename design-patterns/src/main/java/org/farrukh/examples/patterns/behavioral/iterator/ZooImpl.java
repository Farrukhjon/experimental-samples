package org.farrukh.examples.patterns.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

public class ZooImpl implements IZoo {

	List<Animal>	animalList;

	public ZooImpl() {
		animalList = new ArrayList<Animal>();
	}

	@Override
	public List<Animal> getAnimals() {

		return animalList;
	}

	@Override
	public void addAnimal(Animal animal) {
		animalList.add(animal);

	}

	@Override
	public void removeAnimal(Animal animal) {
		animalList.remove(animal);

	}

	@Override
	public Iterator createIterator(String iteratorType) {
		if ("Wild".equals(iteratorType)) {
			return new WildIterator(animalList);
		} else {
			return new DomesticIterator(animalList);
		}
	}
}
