/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.examples.java.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SolvingCommonTasks {

    /**
     * One of the way to create a list from given items is using java.util.Arrays.asList method.
     *
     * @param items given items.
     * @param <T>   some generic type.
     * @return created list.
     */
    public <T> List<T> createList(final T... items) {
        return Arrays.asList(items);
    }

    public <T> List<T> withoutDuplicate(final List<T> list) {
        HashSet<T> hashSet = new HashSet<>(list);
        return new ArrayList<>(hashSet);
    }


}
