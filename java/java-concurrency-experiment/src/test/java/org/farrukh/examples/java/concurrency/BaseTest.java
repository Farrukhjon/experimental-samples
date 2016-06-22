package org.farrukh.examples.java.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    final protected void stop(ExecutorService executor) {
        try {
            executor.shutdown();
            executor.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("Termination interrupted!");
        } finally {
            if(!executor.isTerminated()) {
                System.out.println("Killing non-finished tasks");
                executor.shutdownNow();
            }
        }
    }

    final protected void executeTimes(final ExecutorService executor, final Runnable task, final int times) {
        for (int i = 0; i < times; i++) {
            executor.execute(task);
        }
    }

}
