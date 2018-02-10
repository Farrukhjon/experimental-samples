package org.farrukh.experiments.dp.behavioral.observer.ch4;

import java.util.ArrayList;
import java.util.List;

public class WeatherDataCenter implements Subject {

	private List<Observer>	observers;
	private float			temperature;
	private float			humidity;
	private float			pressure;

	public WeatherDataCenter() {
		observers = new ArrayList<Observer>();
	}

	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		final int index = observers.indexOf(observer);
		if (index >= 0) {
			observers.remove(index);
		}
	}

	@Override
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update(temperature, humidity, pressure);
		}
	}

	private void measurementChanged() {
		notifyObservers();
	}

	public void setMeasurement(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementChanged();
	}

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public float getHumidity() {
		return humidity;
	}

	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}

	public float getPressure() {
		return pressure;
	}

	public void setPressure(float pressure) {
		this.pressure = pressure;
	}

}
