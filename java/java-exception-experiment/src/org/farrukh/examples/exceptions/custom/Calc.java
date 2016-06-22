/**
 * 
 */
package org.farrukh.examples.exceptions.custom;

/**
 * @author Farrukhjon SATTOROV
 *
 */
public class Calc {

	public static void main(String[] args) {
		Calc calc = new Calc();
		try {
			calc.div(1, 0);
		} catch (MyException e) {
			e.printStackTrace();
		}
	}

	public double div(int a, int b) throws MyException {
		double result = 0;
		if (b == 0) {
			throw new MyException("You are stupid, if you think you can divide by zero");
		}
		result = (double) a / b;
		return result;
	}

}
