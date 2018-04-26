/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.examples.algorithms.recursion;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ArrayListOperationsTest {

    private List<Integer> ints;

    @Before
    public void setUp() throws Exception {
        ints = new ArrayList<>();
        for (int number = 1; number <= 5; number++) {
            ints.add(number);
        }
    }

    @Test
    public void test() throws Exception {
        Integer remove = ints.remove(3);

    }
}
