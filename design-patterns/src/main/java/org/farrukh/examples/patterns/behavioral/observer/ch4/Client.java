package org.farrukh.examples.patterns.behavioral.observer.ch4;

public class Client {

	public static void main(String[] args) {

		WeatherDataCenter weatherDataCenter = new WeatherDataCenter();

		CurrentData currentData = new CurrentData(weatherDataCenter);
		Statistic statistic = new Statistic(weatherDataCenter);
		Forecast forecast = new Forecast(weatherDataCenter);

		weatherDataCenter.setMeasurement(11, 2, 10);

		statistic.deleteSubscription();

		weatherDataCenter.setMeasurement(21, 2, 11);
	}

}
