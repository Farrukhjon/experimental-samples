package org.farrukh.examples.cucumber.groovy

/**
 * Created by Farrukhjon on 6/4/15.
 */
class Calculator {
    int a
    int b

    int add() {
        a + b
    }

    int subtract(int a, int b) {
        a - b
    }

    long factorial(int n) {
        if (n <= 1)
            return 1
        return n * factorial(n - 1)
    }
}
