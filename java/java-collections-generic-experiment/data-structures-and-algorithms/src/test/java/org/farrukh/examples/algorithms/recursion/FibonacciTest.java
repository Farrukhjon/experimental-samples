package org.farrukh.examples.algorithms.recursion;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit level test for calculating fibonacci recursively.
 */
public class FibonacciTest {

    @Test
    public void fibonacciTest() {
        //subject under test is created.
        Fibonacci fibonacci = new Fibonacci();

        //and, the helping values holder is created.
        long[] fibonaccies = new long[10];

        // method fibonacci is called
        for(int i = 0; i < 10; i++){
            fibonaccies[i] = fibonacci.fibonacci(i);
        }

        //expected result is returned.
        Assert.assertEquals(0, fibonaccies[0]);
        Assert.assertEquals(1, fibonaccies[1]);
        Assert.assertEquals(1, fibonaccies[2]);
        Assert.assertEquals(2, fibonaccies[3]);
        Assert.assertEquals(3, fibonaccies[4]);
        Assert.assertEquals(5, fibonaccies[5]);
        Assert.assertEquals(8, fibonaccies[6]);
        Assert.assertEquals(13, fibonaccies[7]);
        Assert.assertEquals(21, fibonaccies[8]);
        Assert.assertEquals(34, fibonaccies[9]);
    }
}
