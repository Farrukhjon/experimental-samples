package org.farrukh.examples.java.functional.iteration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class IterationViaStreamRange {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        IntStream.range(0, 10000)
                 .forEach(item -> executor.execute(() ->
                                                           System.out.printf("The value: %s is printed by: %s\n", item, Thread.currentThread()
                                                                                                                              .getName())));
        executor.shutdown();
    }

}
