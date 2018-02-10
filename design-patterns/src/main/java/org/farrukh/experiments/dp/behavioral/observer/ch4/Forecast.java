package org.farrukh.experiments.dp.behavioral.observer.ch4;

public class Forecast implements Observer {

	private float	temperature;
	private float	humidity;
	private float	pressure;
	
	private Subject subject;
	
	public Forecast(Subject subject) {
		this.subject = subject;
		subject.registerObserver(this);
	}

	@Override
	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		display();
	}
	
	@Override
	public void deleteSubscription() {
		this.subject.removeObserver(this);
	}

	private void display() {
		System.out.println(temperature + " " + humidity + " " + pressure);
	}
}
