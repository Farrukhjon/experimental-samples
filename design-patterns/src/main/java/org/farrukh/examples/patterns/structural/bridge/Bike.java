package org.farrukh.examples.patterns.structural.bridge;

/**
 * Refine abstraction 2 in bridge pattern
 */

public class Bike extends AbstractVehicle {

	public Bike(IWorkshop workshop1, IWorkshop workshop2) {
		super(workshop1, workshop2);
	}

	@Override
	public void manufacture() {
		System.out.print("Bike ");
		workshop1.work();
		workshop2.work();
	}
}
