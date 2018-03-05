package org.farrukh.examples.java.collection.stream;

import java.util.Arrays;
import java.util.List;

public class CollectDemo {

    public static void main(String[] args) {
        List<String> letters = Arrays.asList("A", "B", "C");
        letters.forEach(String::toLowerCase);
    }

}
