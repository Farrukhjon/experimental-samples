package org.farrukh.experiments.java.methods;

import java.util.ArrayList;
import java.util.List;

public class PassingListAsParameter {

    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<Integer>();

        integers.add(1);

        System.out.println(integers);

        addItem(integers);

        System.out.println(integers);


    }

    private static void addItem(List<Integer> integers) {
        integers.add(2);
    }

}
