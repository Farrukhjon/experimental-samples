package org.farrukh.examples.java.concurrency;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceFactoryMethodsTest extends BaseTest {

    Runnable printThreadNameTask = () -> {
        String name = Thread.currentThread()
                            .getName();
        System.out.println("Name of the running thread: " + name);
    };

    @Test
    public void testSingleThreadExecutor() {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        executeTimes(singleThreadExecutor, printThreadNameTask, 10);
        stop(singleThreadExecutor);
    }

    @Test
    public void testFixedThreadExecutor() {
        ExecutorService fixedThreadExecutor = Executors.newFixedThreadPool(7);
        executeTimes(fixedThreadExecutor, printThreadNameTask, 7);
        stop(fixedThreadExecutor);
    }

    @Test
    public void testCachedThreadExecutor() {
        ExecutorService cachedThreadExecutor = Executors.newCachedThreadPool();
        executeTimes(cachedThreadExecutor, printThreadNameTask, 7);
        stop(cachedThreadExecutor);
    }

}
