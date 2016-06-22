package org.farrukh.examples.patterns.behavioral.chain.ch2;

public class Numbers {
	private int		number1;
	private int		number2;
	private String	calcWanted;

	public Numbers(int number1, int number2, String calcWanted) {
		this.number1 = number1;
		this.number2 = number2;
		this.calcWanted = calcWanted;
	}

	public int getNumber1() {
		return number1;
	}

	public int getNumber2() {
		return number2;
	}

	public String getCalcWanted() {
		return calcWanted;
	}

}
