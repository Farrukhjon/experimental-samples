/**
 * 
 */
package org.farrukh.examples.algorithms.math;

import java.util.Arrays;
import java.util.BitSet;

/**
 * @author Farrukhjon SATTOROV, Dec 1, 2014
 *
 */
public class FindMissingNumberInArray {

	public int findMissingNumber(int[] array, int count) {
		int expectedSum = count * ((count + 1) / 2);
		int actualSum = 0;
		for (int i : array) {
			actualSum += i;
		}
		return expectedSum - actualSum;
	}

	public int findMissingNumber(int[] array) {
		int missedNumber = 0;
		BitSet bitSet = new BitSet();
		for (Integer number : array) {
			bitSet.set(number - 1);
		}
		return missedNumber;
	}

	public static void main(String[] args) {
		int[] array = {1, 2, 3, 5};

		FindMissingNumberInArray f = new FindMissingNumberInArray();
		int missingNumber = f.findMissingNumber(array, 5);
		System.out.println("missing number in "+Arrays.toString(array)+" is: "+missingNumber);

	}

}
