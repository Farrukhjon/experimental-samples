package org.farrukh.experiments.dp.behavioral.iterator;

import java.util.List;

public class WildIterator implements Iterator {

	public List<Animal>	animalList;
	private int			position;

	public WildIterator(List<Animal> animalList) {
		this.animalList = animalList;
	}

	@Override
	public Animal nextAnimal() {
		Animal animal = null;
		for (; position < animalList.size(); position++) {
			if ("Wild".equals((animalList.get(position)).getAnimalType())) {
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
			if ("Wild".equals((animalList.get(i)).getAnimalType())) {
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
