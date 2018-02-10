package org.farrukh.experiments.dp.behavioral.observer.ch3;

public class Client {

	public static void main(String[] args) {

		WeatherDataCenter weatherDataCenter = new WeatherDataCenter();

		CurrentData currentData = new CurrentData();
		Statistic statistic = new Statistic();
		Forecast forecast = new Forecast();
		
		weatherDataCenter.addObserver(currentData);
		weatherDataCenter.addObserver(statistic);
		weatherDataCenter.addObserver(forecast);
		
		weatherDataCenter.setData(new Temperature(10, 12, 5));
		weatherDataCenter.setData(new Temperature(11, 21, 51));
		
	}

}
