package org.farrukh.experiments.dp.creational.prototype.ch2;

public class Client {

	public static void main(String[] args) {

		CloneFactory cloneMaker = new CloneFactory();

		Sheep saly = new Sheep();

		Sheep clonedSheep = (Sheep) cloneMaker.getClone(saly);

		System.out.println(saly);
		System.out.println(clonedSheep);

		System.out.println("Saly HashCode: " + System.identityHashCode(saly));
		System.out.println("Cloned HashCode: " + System.identityHashCode(clonedSheep));
	}

}
