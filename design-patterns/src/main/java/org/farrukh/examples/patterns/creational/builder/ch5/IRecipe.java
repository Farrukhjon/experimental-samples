package org.farrukh.examples.patterns.creational.builder.ch5;

public interface IRecipe<B> {

	B addIngredient(IIngredient iIngredient);
}
