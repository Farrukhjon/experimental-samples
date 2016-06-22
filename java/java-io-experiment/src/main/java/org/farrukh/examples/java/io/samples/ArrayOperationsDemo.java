package org.farrukh.examples.java.io.samples;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ArrayOperationsDemo {

    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(1, 1, 2, 3, 3, 4, 5);

        int duplicate = findDuplicate(ints);
        System.out.println(duplicate);
    }

    private static int findDuplicate(final List<Integer> list) {
        HashSet<Integer> temp = new HashSet<>(list);
        for (Integer value : list) {
            if (temp.contains(value)) {
                return value;
            }
        }
        return -1;
    }

}
