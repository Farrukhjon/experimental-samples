package org.farrukh.examples.patterns.behavioral.observer.ch2;

public class Client {

	public static void main(String[] args) {

		WeatherDataCenter weatherDataCenter = new WeatherDataCenter();

		CurrentData currentData = new CurrentData();
		Statistic statistic = new Statistic();
		Forecast forecast = new Forecast();

		weatherDataCenter.registerObserver(currentData);
		weatherDataCenter.registerObserver(statistic);
		weatherDataCenter.registerObserver(forecast);

		weatherDataCenter.setMeasurement(11, 2, 10);

		weatherDataCenter.setMeasurement(21, 2, 11);
	}

}
