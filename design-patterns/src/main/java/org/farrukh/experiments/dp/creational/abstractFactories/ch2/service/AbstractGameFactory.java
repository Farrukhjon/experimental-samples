package org.farrukh.experiments.dp.creational.abstractFactories.ch2.service;

public interface AbstractGameFactory {
	
	Ball makeObstacle();

	Player makePlayer();
}
