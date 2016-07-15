/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.examples.java.functional.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.data.Index.atIndex;

public class StreamCollectAndCollectorsTests {

    private final List<Integer> givenNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

    @Test
    public void shouldConvertItemsToDoubleAndCollectToNewList() throws Exception {
        List<Double> doubleNumbers = givenNumbers.stream()
                                                 .map(Integer::doubleValue)
                                                 .collect(Collectors.toList());
        assertThat(doubleNumbers)
                .contains(1.0, atIndex(0))
                .contains(2.0, atIndex(1))
                .contains(3.0, atIndex(2))
                .contains(4.0, atIndex(3))
                .contains(5.0, atIndex(4))
                .contains(6.0, atIndex(5))
                .contains(7.0, atIndex(6));
    }

    @Test
    public void shouldCollectToMap() throws Exception {
        Map<Integer, Double> doubleMap = givenNumbers.stream()
                                                     .collect(toMap(Function.identity(), Integer::doubleValue));
        assertThat(doubleMap)
                .containsEntry(1, 1.0)
                .containsEntry(2, 2.0)
                .containsEntry(3, 3.0)
                .containsEntry(4, 4.0)
                .containsEntry(5, 5.0)
                .containsEntry(6, 6.0)
                .containsEntry(7, 7.0);
    }

}
