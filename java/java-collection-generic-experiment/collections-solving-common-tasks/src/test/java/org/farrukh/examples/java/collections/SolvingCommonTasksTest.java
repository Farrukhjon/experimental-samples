/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.examples.java.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SolvingCommonTasksTest {

    private SolvingCommonTasks subjectUnderTest = new SolvingCommonTasks();

    @Test
    public void shouldCreateAListFromGivenVarargs() {
        List<Integer> aList = subjectUnderTest.createList(1, 2, 3, 4);
        int expectedSize = 4;
        Class<List> expectedType = List.class;
        assertThat(aList)
                .isInstanceOf(expectedType)
                .size().isEqualTo(expectedSize);
    }

    @Test
    public void shouldGetRidFromDuplicateElements() {
        List<String> names = new ArrayList<>();
        names.add("Ali");
        names.add("Vali");
        names.add("Sami");
        names.add("Ali");
        names.add("Gani");
        List<String> withoutDuplicate = subjectUnderTest.withoutDuplicate(names);
        assertThat(withoutDuplicate).containsOnly("Ali", "Vali", "Sami", "Gani");
    }
}
