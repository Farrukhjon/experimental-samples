/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.examples.structures.array;

public class ArrayOperations {

    public static int delete(int[] a, int index) {
        int deletedVale = a[index];
        int size = a.length;
        System.arraycopy(a, index + 1, a,index, size - index -1);
        return deletedVale;
    }

}
