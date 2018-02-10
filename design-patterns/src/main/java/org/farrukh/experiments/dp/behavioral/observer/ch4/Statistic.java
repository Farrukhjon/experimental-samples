package org.farrukh.experiments.dp.behavioral.observer.ch4;

public class Statistic implements Observer {

	private float	maxTemp	= 0.0f;
	private float	minTemp	= 200;
	private float	tempSum	= 0.0f;
	private int		numReadings;
	
	private Subject subject;
	
	public Statistic(Subject subject) {
		this.subject = subject;
		subject.registerObserver(this);
	}

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
	
	@Override
	public void deleteSubscription() {
		this.subject.removeObserver(this);
	}

	private void display() {
		System.out.println("statistic: Avg/Max/Min temperature = " + (tempSum / numReadings) + "/" + maxTemp + "/" + minTemp);
	}

}
