package org.farrukh.examples.patterns.creational.abstractFactories.ch2.service;

public interface AbstractGameFactory {
	
	Ball makeObstacle();

	Player makePlayer();
}
