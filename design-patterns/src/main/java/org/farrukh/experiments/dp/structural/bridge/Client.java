package org.farrukh.experiments.dp.structural.bridge;

/**
 * Demonstration of bridge design pattern
 * 
 **/

public class Client {

	public static void main(String[] args) {

		AbstractVehicle car = new Car(new Produce(), new Assemble());
		car.manufacture();

		AbstractVehicle bike = new Bike(new Produce(), new Assemble());
		bike.manufacture();
	}
}
