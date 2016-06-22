package org.farrukh.examples.patterns.behavioral.observer.ch3;

import java.util.Observable;
import java.util.Observer;

public class Forecast implements Observer {

	private float	temperature;
	private float	humidity;
	private float	pressure;
	
	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof Temperature) {
			Temperature temperature = (Temperature) arg;
			this.temperature = temperature.getTemperature();
			this.humidity = temperature.getHumidity();
			this.pressure = temperature.getPressure();
			display();
		}
	}

	private void display() {
		System.out.println(temperature + " " + humidity + " " + pressure);
	}
}
