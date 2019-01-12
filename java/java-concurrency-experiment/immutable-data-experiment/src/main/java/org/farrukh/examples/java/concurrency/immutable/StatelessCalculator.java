/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.examples.java.concurrency.immutable;

/**
 * An Instance of this class represents a simplest immutable object which has no internal fields at all.
 */
public class StatelessCalculator {

    public int add(int a, int b) {
        return a + b;
    }

}
