package org.farrukh.examples.java.functional.collection.reduction;

import org.farrukh.examples.java.functional.streams.reduction.Summer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSummer {

    private int[] numbers = {0, 1, 2, 3, 4, 5};

    private Summer summer = new Summer();

    @Test
    public void testSumAllItemsOfIntArrayByIteration() {
        int result = summer.sumByIteration(numbers);
        assertEquals(15, result);
    }

    @Test
    public void testSumAllItemsOfIntArrayByIntStreamSum() {
        int result = summer.sumIntStreamSum(numbers);
        assertEquals(15, result);
    }


    @Test
    public void testSumAllItemsOfIntArrayByStreamReduce() {
        int result = summer.sumStreamReduce(numbers);
        assertEquals(15, result);
    }

    @Test
    public void testSumAllItemsOfIntArrayByStreamReduceRefMethod() {
        int result = summer.sumStreamReduceRefMethod(numbers);
        assertEquals(15, result);
    }

}
