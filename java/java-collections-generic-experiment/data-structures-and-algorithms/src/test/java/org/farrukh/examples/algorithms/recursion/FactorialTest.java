package org.farrukh.examples.algorithms.recursion;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit level test for calculating factorial recursively.
 */
public class FactorialTest {

    @Test
    public void testFactorial() {
        //Factorial object is created
        Factorial factorial = new Factorial();

        //factorial method is called
        long factorial_from_0 = factorial.factorial(0);
        long factorial_from_1 = factorial.factorial(1);
        long factorial_from_5 = factorial.factorial(5);
        long factorial_from_10 = factorial.factorial(10);

        //expected result is returned
        assertEquals(1, factorial_from_0);
        assertEquals(1, factorial_from_1);
        assertEquals(120, factorial_from_5);
        assertEquals(3628800, factorial_from_10);
    }
}
