/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukhjon.java.collections;

import org.junit.Test;

import java.util.Collections;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class CollectionsDemoTests {

    @Test
    public void shouldThrownUnsupportedOperationExceptionWhenAddAnItem() {
        int item = 1;
        int extraItem = 2;
        Set<Integer> integers = Collections.singleton(item);
        assertThat(integers)
                .containsOnly(item);
        try {
            integers.add(extraItem);
        } catch (Exception e) {
            assertThatExceptionOfType(UnsupportedOperationException.class)
                    .isThrownBy(() -> {
                        throw new UnsupportedOperationException("Boom!");
                    })
                    .withMessage("Boom!")
                    .withNoCause();
        }
    }

}
