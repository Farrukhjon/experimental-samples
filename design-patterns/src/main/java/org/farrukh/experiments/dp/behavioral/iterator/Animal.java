package org.farrukh.experiments.dp.behavioral.iterator;

public class Animal {
	private String	animalName;
	private String	animalType;

	public Animal(String animalName, String animalType) {
		this.animalName = animalName;
		this.animalType = animalType;
	}

	public String getAnimalName() {
		return animalName;
	}

	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}

	public String getAnimalType() {
		return animalType;
	}

	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}
}
