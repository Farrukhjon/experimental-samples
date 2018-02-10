package org.farrukh.experiments.dp.creational.abstractFactories.ch2.impl;


import org.farrukh.experiments.dp.creational.abstractFactories.ch2.service.AbstractGameFactory;
import org.farrukh.experiments.dp.creational.abstractFactories.ch2.service.Ball;
import org.farrukh.experiments.dp.creational.abstractFactories.ch2.service.Player;

public class FootBallFactory implements AbstractGameFactory {

	@Override
	public Ball makeObstacle() {
		return new FootBall();
	}
	
	@Override
	public Player makePlayer() {
		return new PlayerB();
	}
}
