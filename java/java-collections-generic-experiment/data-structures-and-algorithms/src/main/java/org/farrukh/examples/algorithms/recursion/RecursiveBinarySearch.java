package org.farrukh.examples.algorithms.recursion;

/**
 * Binary search (also half-interval search) finds position (index) of a target value
 * within sorted array.
 */
public class RecursiveBinarySearch {

    public int binarySearch(long[] array, int target) {
        return binarySearch(array, 0, array.length - 1, target);
    }

    private int binarySearch(long[] array, int fromIndex, int toIndex, int target) {
        if (fromIndex > toIndex)
            return -1;
        int middle = (fromIndex + toIndex) / 2;
        if (target == array[middle])
            return middle;
        else if (array[middle] > target)
            return binarySearch(array, fromIndex, middle - 1, target);
        else
            return binarySearch(array, middle + 1, toIndex, target);
    }

}
