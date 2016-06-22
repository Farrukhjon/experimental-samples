package org.farrukh.examples.patterns.creational.builder.ch5;

public interface IBuilder<T> extends IRecipe<IBuilder<T>> {

	T build();
}
