/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukhjon.java.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo {

    public static void main(String[] args) {
        List<String> emptyImmutableList = Collections.EMPTY_LIST;

        List<Integer> modifiableList = new ArrayList<>();
        modifiableList.add(1);
        modifiableList.add(2);
        modifiableList.add(3);

        List<Integer> unmodifiableList = Collections.unmodifiableList(modifiableList);

        unmodifiableList.add(4);

        System.out.println(emptyImmutableList);

    }

}
