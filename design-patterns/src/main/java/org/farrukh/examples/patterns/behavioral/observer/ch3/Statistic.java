package org.farrukh.examples.patterns.behavioral.observer.ch3;

import java.util.Observable;
import java.util.Observer;

public class Statistic implements Observer {

	private float	maxTemp	= 0.0f;
	private float	minTemp	= 200;
	private float	tempSum	= 0.0f;
	private int		numReadings;

	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof Temperature) {
			Temperature temperature = (Temperature) arg;
			this.maxTemp = temperature.getMaxTemp();
			this.minTemp = temperature.getMinTemp();
			display();
		}
	}

	private void display() {
		System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings) + "/" + maxTemp + "/" + minTemp);
	}

}
