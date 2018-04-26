package org.farrukh.examples.algorithms.recursion;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit level test of binary search algorithm
 */
public class RecursiveBinarySearchTest {

    @Test
    public void testRecursiveBinarySearchAlgorithm() {
        RecursiveBinarySearch algorithm = new RecursiveBinarySearch();

        long[] sortedArray = {0, 11, 21, 31, 41, 51, 61, 71, 81, 91, 101};

        int result = algorithm.binarySearch(sortedArray, 81);

        assertEquals(8, result);
    }
}
