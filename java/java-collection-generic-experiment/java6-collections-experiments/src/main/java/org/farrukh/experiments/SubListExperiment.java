package org.farrukh.experiments;

import java.util.ArrayList;
import java.util.List;

public class SubListExperiment {

    public static final int COUNT_OF_GET = 25;

    public static void main(String[] args) {
        List<Integer> originalList = new ArrayList<Integer>();

        for (int i = 0; i < 25; i++) {
            originalList.add(i);
        }

/*        for (int i = 0; i < originalList.size(); i++) {
            if (i > 0 && isDivisibleBy(i)) {
                List<Integer> subList = originalList.subList(0, COUNT_OF_GET);
                sendRequest(subList);
                originalList.subList(0, COUNT_OF_GET).clear();
                System.out.println("Clearing up");
            }
            if (originalList.size() <= COUNT_OF_GET ) {
                sendRequest(originalList);
            }
        }
        */
        while(originalList.size() >= COUNT_OF_GET) {
            List<Integer> subList = originalList.subList(0, COUNT_OF_GET);
            sendRequest(subList);
            originalList.subList(0, COUNT_OF_GET).clear();
            System.out.println("Clearing up");
        }
        System.out.println("sent:" + originalList);
        sendRequest(originalList);
    }

    private static void sendRequest(List<Integer> list) {
        System.out.println(String.format("Handling the request for items: %s", list));
    }

    private static boolean isDivisibleBy(int aNumber) {
        return aNumber % COUNT_OF_GET == 0;
    }

}
