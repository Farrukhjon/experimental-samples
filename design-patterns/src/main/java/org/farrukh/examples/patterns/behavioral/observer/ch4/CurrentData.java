package org.farrukh.examples.patterns.behavioral.observer.ch4;

public class CurrentData implements Observer {

	private float	temperature;
	private float	humidity;
	private float	pressure;
	
	private Subject subject;

	public CurrentData(Subject subject) {
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
		System.out.println("current condition: " + temperature + "F degree and " + humidity + "% humidity and " + "pressure: " + pressure);
	}

}
