/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.examples.java.concurrency.immutable;

/**
 * An Instance of this class represents a simplest immutable object which has a final field at all.
 */
public class ImmutableCalculator {

    private final int offset;

    public ImmutableCalculator(final int a) {
        this.offset = a;
    }

    public int add(int b) {
        return offset + b;
    }


}
