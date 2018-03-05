package org.farrukh.examples.java.generic.basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UnsafeIterationOverCollection {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("Hello");
        list.add("World");
        list.add(10);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String strValue = (String) it.next();
            System.out.println(strValue);
        }
    }

}
