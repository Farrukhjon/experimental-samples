package org.farrukh.experiments.dp.behavioral.observer.ch4;

public interface Subject {

	public void registerObserver(Observer observer);

	public void removeObserver(Observer observer);

	public void notifyObservers();
}
