package org.farrukh.examples.patterns.creational.builder.ch1;

public abstract class AbstractBuilder {

	public static AbstractBuilder getInstance() {
		AbstractBuilder builder = null;
		return builder;
	}

	public abstract void buildPart();

}
