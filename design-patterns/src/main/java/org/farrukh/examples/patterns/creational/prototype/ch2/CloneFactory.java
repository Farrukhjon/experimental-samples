package org.farrukh.examples.patterns.creational.prototype.ch2;

public class CloneFactory {

	public Animal getClone(Animal simpleAnimal) {
		return simpleAnimal.makeCopy();
	}

}
