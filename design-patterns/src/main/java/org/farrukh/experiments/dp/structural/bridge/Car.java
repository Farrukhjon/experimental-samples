package org.farrukh.experiments.dp.structural.bridge;

/**
* Refine abstraction 1 in bridge pattern
*/

public class Car extends AbstractVehicle {

	public Car(IWorkshop workshop1, IWorkshop workshop2) {
		super(workshop1, workshop2);
	}

	@Override
	public void manufacture() {
		System.out.print("Car ");
		workshop1.work();
		workshop2.work();
	}
}
