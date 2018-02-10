package org.farrukh.experiments.dp.creational.prototype.ch2;

public class Sheep implements Animal {

	public Sheep() {
		System.out.println("Sheep is made");
	}

	@Override
	public Animal makeCopy() {
		System.out.println("Sheep is Being Made");
		Sheep sheepObject = null;
		try {
			sheepObject = (Sheep) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return sheepObject;
	}

	@Override
	public String toString() {
		return "Dolly says Baaaa!";
	}

}
