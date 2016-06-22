package org.farrukh.examples.patterns.creational.builder.ch5;

import java.util.ArrayList;
import java.util.List;

public class CakeBuilder implements IBuilder<Cake> {

	// IN THIS CASE THE PARTS ARE THE INGREDIENTS
	private List<IIngredient>	ingredients	= new ArrayList<IIngredient>();

	@Override
	public Cake build() {
		if (!ingredients.isEmpty()) {
			// THE FINAL PRODUCT IS A CHOCO-MUFFIN
			return new Cake(ingredients);
		}
		return new Cake(null);
	}

	@Override
	// BECAUSE I ALWAYS GET A BUILDER BACK, I'M ABLE TO
	// ADD A LOT OF PARTS BEFORE I CALL "BUILD()"
	public IBuilder<Cake> addIngredient(IIngredient ingredient) {
		if (ingredient != null) {
			ingredients.add(ingredient);
		}
		return this;
	}

}
