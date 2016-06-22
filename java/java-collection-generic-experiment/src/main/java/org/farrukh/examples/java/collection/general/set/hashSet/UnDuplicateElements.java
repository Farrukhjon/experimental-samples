package org.farrukh.examples.java.collection.general.set.hashSet;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Farrukhjon on 25-Sep-15.
 */
public class UnDuplicateElements {

    public static void main(String[] args) {
        Collection duplicatedCollection = Arrays.asList(1, 2, 3, 4, 4, 5, 5, 2, 5);
        System.out.println("Duplicated collection " + duplicatedCollection);

        Collection<Integer> noDuplicatedCollection = new HashSet<>(duplicatedCollection);
        System.out.print("Unduplicated collection " + noDuplicatedCollection);

    }
}
