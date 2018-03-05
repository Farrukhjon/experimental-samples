package org.farrukh.experiments;

import java.util.ArrayList;
import java.util.List;

public class SubListExperiment {

    private static final int COUNT = 25;

    public static void main(String[] args) {
        List<Integer> originalList = new ArrayList<Integer>();

        for (int i = 0; i < 25; i++) {
            originalList.add(i);
        }

        while(originalList.size() >= COUNT) {
            List<Integer> subList = originalList.subList(0, COUNT);
            System.out.println(String.format("Sub list of %s is %s", originalList, subList));
            originalList.subList(0, COUNT).clear();
        }
        System.out.println("sent:" + originalList);
    }

}
