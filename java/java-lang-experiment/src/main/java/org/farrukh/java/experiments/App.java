package org.farrukh.java.experiments;

/**
 * Hello world!
 *
 */
public class App {
    
    private static final String HELLO_WORLD = "Hello World!";

    public static void main(String[] args) {
        extracted();
    }

    private static void extracted() {
        String x = HELLO_WORLD;
        System.out.println(x);
    }
}
