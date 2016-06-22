package org.farrukh.examples.patterns.behavioral.observer.ch2;

public class Statistic implements Observer {

	private float	maxTemp	= 0.0f;
	private float	minTemp	= 200;
	private float	tempSum	= 0.0f;
	private int		numReadings;

	@Override
	public void update(float temperature, float humidity, float pressure) {
		tempSum += temperature;
		numReadings++;

		if (temperature > maxTemp) {
			maxTemp = temperature;
		}

		if (temperature < minTemp) {
			minTemp = temperature;
		}
		display();
	}

	private void display() {
		System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings) + "/" + maxTemp + "/" + minTemp);
	}

}
