package org.farrukh.experiments.dp.creational.builder.ch5;

public interface IBuilder<T> extends IRecipe<IBuilder<T>> {

	T build();
}
