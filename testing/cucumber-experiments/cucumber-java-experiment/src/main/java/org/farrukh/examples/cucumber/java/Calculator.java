package org.farrukh.examples.cucumber.java;

/**
 * Created by Farrukhjon on 25-Sep-15.
 */
public class Calculator {

    private int result;

    public void add(final int a, final int b) {
        result = a + b;
    }

    public int getResult() {
        return result;
    }
}
