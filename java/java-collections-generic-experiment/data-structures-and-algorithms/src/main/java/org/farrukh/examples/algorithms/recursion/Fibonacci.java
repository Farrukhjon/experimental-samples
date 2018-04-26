package org.farrukh.examples.algorithms.recursion;

/**
 * Fibonacci number by recursion.
 */
public class Fibonacci {

    /**
     * @param number positive number.
     * @return a fibonacci of the given number.
     */
    public long fibonacci(int number) {
        if (number <= 1) {
            return number;
        }
        return fibonacci(number - 1) + fibonacci(number - 2);
    }

}
