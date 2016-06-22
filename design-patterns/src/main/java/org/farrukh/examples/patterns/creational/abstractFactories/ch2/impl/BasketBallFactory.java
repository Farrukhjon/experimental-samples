package org.farrukh.examples.patterns.creational.abstractFactories.ch2.impl;


import org.farrukh.examples.patterns.creational.abstractFactories.ch2.service.AbstractGameFactory;
import org.farrukh.examples.patterns.creational.abstractFactories.ch2.service.Ball;
import org.farrukh.examples.patterns.creational.abstractFactories.ch2.service.Player;

public class BasketBallFactory implements AbstractGameFactory {

	@Override
	public Ball makeObstacle() {
		return new BasketBall();
	}

	@Override
	public Player makePlayer() {
		return new PlayerA();
	}
}
