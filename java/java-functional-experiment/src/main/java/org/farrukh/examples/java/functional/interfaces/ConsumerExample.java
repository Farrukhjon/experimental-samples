package org.farrukh.examples.java.functional.interfaces;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * Created by Farrukhjon on 18-Sep-15.
 */
public class ConsumerExample {

    public static void main(String[] args) {
        Consumer<Integer> integerConsumer = it -> System.out.println(it * 2);
        Arrays.asList(1, 2, 3, 4, 5).stream().forEach(integerConsumer);
    }
}
