package org.farrukh.examples.java.concurrency;

import org.junit.Assert;
import org.junit.Test;
import synchronization.Counter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CounterTest {

    @Test
    public void shouldTestIncrementCounter() {
        Counter sut = new Counter();
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                sut.increment();
            }
        };

        executorService.execute(runnable);

        int count = sut.getCount();

        Assert.assertEquals(10, count);
    }
}
