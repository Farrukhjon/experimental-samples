package org.farrukh.examples.patterns.behavioral.observer.ch3;

public class Temperature {

	private float	humidity;
	private float	pressure;
	private float	temperature;

	private float	maxTemp	= 0.0f;
	private float	minTemp	= 200;
	private float	tempSum	= 0.0f;
	private int		numReadings;

	public Temperature(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		calc();
	}

	private void calc() {
		tempSum += temperature;
		numReadings++;
		if (temperature > maxTemp) {
			maxTemp = temperature;
		}
		if (temperature < minTemp) {
			minTemp = temperature;
		}
	}

	public float getHumidity() {
		return humidity;
	}

	public float getPressure() {
		return pressure;
	}

	public float getTemperature() {
		return temperature;
	}

	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}

	public void setPressure(float pressure) {
		this.pressure = pressure;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public float getMaxTemp() {
		return maxTemp;
	}

	public void setMaxTemp(float maxTemp) {
		this.maxTemp = maxTemp;
	}

	public float getMinTemp() {
		return minTemp;
	}

	public void setMinTemp(float minTemp) {
		this.minTemp = minTemp;
	}

	public float getTempSum() {
		return tempSum;
	}

	public void setTempSum(float tempSum) {
		this.tempSum = tempSum;
	}

	public int getNumReadings() {
		return numReadings;
	}

	public void setNumReadings(int numReadings) {
		this.numReadings = numReadings;
	}

}
