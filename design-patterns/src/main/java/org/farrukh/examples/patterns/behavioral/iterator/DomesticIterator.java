package org.farrukh.examples.patterns.behavioral.iterator;

import java.util.List;

public class DomesticIterator implements Iterator {

	List<Animal>	animalList;
	private int		position;

	public DomesticIterator(List<Animal> animalList) {
		this.animalList = animalList;
	}

	@Override
	public Animal nextAnimal() {
		Animal animal = null;
		for (; position < animalList.size(); position++) {
			if ("Domestic".equals((animalList.get(position)).getAnimalType())) {
				animal = animalList.get(position);
				position++;
				break;
			}
		}
		return animal;
	}

	@Override
	public boolean isLastAnimal() {
		for (int i = position; i < animalList.size(); i++) {
			if ("Domestic".equals((animalList.get(i)).getAnimalType())) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Animal currentAnimal() {
		if (position < animalList.size()) {
			return animalList.get(position);
		}
		return null;
	}

}
