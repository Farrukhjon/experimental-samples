package org.farrukh.experiments.dp.creational.builder.ch5;

public class Milk implements IIngredient {

	private int		deciLiter;
	private int		calories;
	private String	unitPrice;

	public Milk(int deciLiter) {
		this.deciLiter = deciLiter;
	}

	public Milk(int deciLiter, int calories, String unitPrice) {
		super();
		this.deciLiter = deciLiter;
		this.calories = calories;
		this.unitPrice = unitPrice;
	}

	@Override
	public void printName() {
		System.out.printf(" Milk");
	}

	@Override
	public String getUnitPrice() {
		return unitPrice;
	}

	@Override
	public void printCalories() {
		System.out.printf(" 128kc");
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
