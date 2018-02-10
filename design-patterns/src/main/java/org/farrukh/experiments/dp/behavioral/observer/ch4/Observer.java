package org.farrukh.experiments.dp.behavioral.observer.ch4;

public interface Observer {

	public void update(float temperature, float humidity, float pressure);
	
	public void deleteSubscription();
}
