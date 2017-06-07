package org.farrukh.experiments;

import org.apache.commons.math3.primes.Primes;

import static java.lang.String.format;


public class App {
    public static void main(String[] args) {

        for (int i = 1; i <= 1000; i++) {
            System.out.println(format("A Number: %s, Modulo: %s, Result: %s", i, (i % 47 == 0), i % 47));
        }

    }
}
