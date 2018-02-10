package org.farrukh.experiments.dp.creational.builder.ch5;

public class Choco implements IIngredient {

	private int		gram;
	private int		calories;
	private String	unitPrice;

	public Choco(int gram, int calories, String unitPrice) {
		super();
		this.gram = gram;
		this.calories = calories;
		this.unitPrice = unitPrice;
	}

	public int getGram() {
		return gram;
	}

	public void setGram(int gram) {
		this.gram = gram;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Override
	public void printName() {
		System.out.printf(" Chocolate");
	}

	@Override
	public void printCalories() {
		System.out.printf(" 389kc");
	}

	@Override
	public String getUnitPrice() {
		return unitPrice;
	}

}
