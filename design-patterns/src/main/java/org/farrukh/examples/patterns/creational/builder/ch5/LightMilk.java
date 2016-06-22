package org.farrukh.examples.patterns.creational.builder.ch5;

public class LightMilk implements IIngredient {

	private int		deciLiter;
	private int		calories;
	private String	unitPrice;

	public LightMilk(int deciLiter) {
		this.deciLiter = deciLiter;
	}

	public LightMilk(int deciLiter, int calories, String unitPrice) {
		super();
		this.deciLiter = deciLiter;
		this.calories = calories;
		this.unitPrice = unitPrice;
	}

	@Override
	public void printName() {
		System.out.printf(" Light Milk");
	}

	@Override
	public String getUnitPrice() {
		return unitPrice;
	}

	@Override
	public void printCalories() {
		System.out.printf(" 76kc");
	}

	public int getDeciLiter() {
		return deciLiter;
	}

	public void setDeciLiter(int deciLiter) {
		this.deciLiter = deciLiter;
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

}
