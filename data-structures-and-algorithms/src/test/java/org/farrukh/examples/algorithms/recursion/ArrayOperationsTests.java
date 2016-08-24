/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.examples.algorithms.recursion;

import org.farrukh.examples.structures.array.ArrayOperations;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class ArrayOperationsTests {

    /**
     * Array under test
     */
    private String[] aut = null;

    @Before
    public void setUp() throws Exception {
        aut = new String[]{"Ali", "Vali", "Sami", "Gani", "Surayo", "Muhayo"};
    }

    @Test
    public void arrayInitialized() throws Exception {
        assertTrue(aut.length > 0);
    }

    @Test
    public void shouldTestDeletingElementByIndexFromArray() throws Exception {
        int[] a = new int[]{1, 2, 3, 4};
        int lengthBefore = a.length;
        int deleteElement = ArrayOperations.delete(a, 2);
        int lengthAfter = a.length;
        Assert.assertTrue(lengthBefore > lengthAfter);
    }

    @Test
    public void testCopyOf() throws Exception {
        String[] newArray = Arrays.copyOf(aut, aut.length - 1);
        Assert.assertTrue(newArray.length < aut.length);
    }
}
