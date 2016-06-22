package org.farrukh.examples.java.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Farrukhjon on 26-Sep-15.
 */
public class UtilityArraysTests {

    @Test
    public void testAsListMethod() {
        List<Integer> integers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(5);
        expected.add(6);
        expected.add(7);

        assertNotNull(integers);
        assertEquals(expected, integers);
        assertNotSame(expected, integers);
    }

    @Test
    public void testSortMethod() {
        //given
        int[] someNumbers = {0, 1, 3, 8, 9, 4, 2, 7, 6, 5, 10};

        //when
        Arrays.sort(someNumbers);

        //then

        assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, someNumbers);

    }


}
