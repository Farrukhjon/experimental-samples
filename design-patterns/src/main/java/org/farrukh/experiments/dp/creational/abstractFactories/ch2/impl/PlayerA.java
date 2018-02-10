package org.farrukh.experiments.dp.creational.abstractFactories.ch2.impl;


import org.farrukh.experiments.dp.creational.abstractFactories.ch2.service.Ball;
import org.farrukh.experiments.dp.creational.abstractFactories.ch2.service.Player;

public class PlayerA implements Player {

	@Override
	public void kick(Ball ball) {
		System.out.println("Player A");
		ball.action();
	}
}
