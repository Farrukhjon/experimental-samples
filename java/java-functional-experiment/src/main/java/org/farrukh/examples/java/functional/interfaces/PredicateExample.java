package org.farrukh.examples.java.functional.interfaces;

import java.util.Arrays;
import java.util.function.Predicate;

/**
 * Created by Farrukhjon on 18-Sep-15.
 */
public class PredicateExample {

    public static void main(String[] args) {
        Predicate<Integer> evenPredicate = it -> it % 2 == 0;
        long count = Arrays.asList(1, 2, 3, 4, 5).stream().filter(evenPredicate).count();
        assert count == 2;
    }
}
