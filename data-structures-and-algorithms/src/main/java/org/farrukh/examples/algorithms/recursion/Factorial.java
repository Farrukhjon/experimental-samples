package org.farrukh.examples.algorithms.recursion;

/**
 * Factorial by recursion.
 */
public class Factorial {

    /**
     * @param number a positive number.
     * @return factorial of the given number.
     */
    public long factorial(int number) {
        if (number <= 1) {
            return 1;
        }
        return number * factorial(number - 1);
    }
}
