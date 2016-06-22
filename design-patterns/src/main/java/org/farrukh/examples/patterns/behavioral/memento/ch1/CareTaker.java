package org.farrukh.examples.patterns.behavioral.memento.ch1;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {

	private List<Momento>	savedArticles	= new ArrayList<Momento>();

	public void addMomnto(Momento momento) {
		savedArticles.add(momento);
	}

	public Momento getMomento(int index) {
		return savedArticles.get(index);
	}
}
