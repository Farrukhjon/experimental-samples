package org.farrukh.examples.patterns.creational.abstractFactories.ch2.impl;


import org.farrukh.examples.patterns.creational.abstractFactories.ch2.service.Ball;

public class FootBall implements Ball {
	
	public void action() {
		System.out.println("Foot pass");
	}
}
