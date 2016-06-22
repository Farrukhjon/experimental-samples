package org.farrukh.examples.patterns.structural.bridge;

/**
 * Concrete implementation 2 for bridge pattern
 * */

public class Assemble implements IWorkshop {
	
	@Override
	public void work() {
		System.out.println("Assembling...");
	}
}
