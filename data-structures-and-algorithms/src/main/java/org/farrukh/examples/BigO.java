/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.examples;

import java.util.Arrays;
import java.util.function.BiConsumer;

import static java.lang.System.currentTimeMillis;

/**
 * Should provide time and space calculation of an algorithm.
 */
public class BigO {

    private static final String CONSTANT_TIME = "BEST";
    private static final String LOGARITHMIC_TIME = "GOOD";
    private static final String PROPORTIONAL_TIME = "FAIR";

    public <T> void calculate(BiConsumer<T[], T> algorithm, T[] arg1, T arg2) {
        double calcTime = elapsedTime(algorithm, arg1, arg2);
        if (calcTime >= arg1.length)
            System.out.println(PROPORTIONAL_TIME);
        else if (calcTime == Math.log(arg1.length))
            System.out.println(LOGARITHMIC_TIME);
        else
            System.out.println(CONSTANT_TIME);
    }

    private <T> double elapsedTime(BiConsumer<T[], T> algorithm, T[] arg1, T arg2) {
        long start = currentTimeMillis();
        algorithm.accept(arg1, arg2);
        long end = currentTimeMillis();
        return (end - start) / 1000.0;
    }

    public static void main(String[] args) {
        BigO bigO = new BigO();
        int n = 1000000;
        Integer[] ints = new Integer[n];
        for (int i = 0; i < n; i++) {
            ints[i] = i * 2;
        }
        bigO.calculate(Arrays::binarySearch, ints, n);
    }

}
