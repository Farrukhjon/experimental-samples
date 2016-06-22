package org.farrukh.examples.patterns.creational.builder.ch5;

import java.util.List;

public class Cake {

	public Cake(List<IIngredient> ingredients) {
		String muffin = "";
		if (ingredients == null) {
			System.out.println(" zero cake " + muffin);
			return;
		}
		// PRINT OUT MUFFIN INGREDIENTS
		System.out.printf(" Cake with: ");
		for (IIngredient ingredient : ingredients) {
			ingredient.printName();
		}
		// PRINT OUT PART PRICES
		for (IIngredient ingredient : ingredients) {
			muffin += " " + ingredient.getUnitPrice();// NOPMD
		}
		System.out.println(" - Price: " + muffin);
	}

	public void printResult() {
		System.out.println(" Cake is ready!");
	}
}
