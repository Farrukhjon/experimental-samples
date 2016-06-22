package org.farrukh.examples.patterns.behavioral.observer.ch2;

public interface Subject {

	public void registerObserver(Observer observer);

	public void removeObserver(Observer observer);

	public void notifyObservers();
}
