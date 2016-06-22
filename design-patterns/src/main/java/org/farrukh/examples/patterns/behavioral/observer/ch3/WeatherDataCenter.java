package org.farrukh.examples.patterns.behavioral.observer.ch3;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
/**
 * Subject class
 * */
public class WeatherDataCenter extends Observable {

	private boolean			changed;
	private List<Observer>	observers;
	private Temperature		data;

	public WeatherDataCenter() {
		observers = new ArrayList<Observer>();
	}

	@Override
	public synchronized void addObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public synchronized void deleteObserver(Observer o) {
		final int index = observers.indexOf(o);
		if (index >= 0) {
			observers.remove(index);
		}
	}

	@Override
	public synchronized void deleteObservers() {
		observers.clear();
	}

	@Override
	public synchronized boolean hasChanged() {
		return this.changed;
	}

	@Override
	public void notifyObservers() {
		notifyObservers(this.data);
	}

	@Override
	public void notifyObservers(Object arg) {
		if (changed) {
			for (Observer observer : observers) {
				observer.update(this, arg);
			}
		}
		changed = false;
	}

	@Override
	protected synchronized void setChanged() {
		this.changed = true;
	}

	public void setData(Temperature data) {
		this.data = data;
		setChanged();
		notifyObservers();
	}

	public Temperature getData() {
		return data;
	}

}
