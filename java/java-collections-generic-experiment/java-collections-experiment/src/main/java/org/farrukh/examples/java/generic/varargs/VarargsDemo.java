/**
 * 
 */
package org.farrukh.examples.java.generic.varargs;

/**
 * @author Farrukhjon SATTOROV, Dec 10, 2014
 *
 */
public class VarargsDemo {

	public static void main(String[] args) {
		int sumResult = sum(1, 2, 3);
		assert sumResult == 6;
	}

	private static int sum(int... n) {
		int sum = 0;
		for (int i : n) {
			sum += i;
		}
		return sum;
	}
}
