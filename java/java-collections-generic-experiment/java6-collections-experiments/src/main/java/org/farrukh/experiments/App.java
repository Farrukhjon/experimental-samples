package org.farrukh.experiments;


import java.util.ArrayList;
import java.util.Random;

public class App {

    public static void main(String[] args) {
        Random random1 = new Random();
        ArrayList<Object> arrayList = new ArrayList<Object>();
        while (true) {

            int random = random1.nextInt(500);
            arrayList.add(new Object());
            if (arrayList.size() >= random) {
                handleAndClean(arrayList);
            }
        }
    }

    private static void handleAndClean(ArrayList<Object> arrayList) {
        for (Object o : arrayList) {
            System.out.println(o);
        }
        arrayList.clear();
        arrayList.trimToSize();
    }


}
