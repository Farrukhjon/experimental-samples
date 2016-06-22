package org.farrukh.examples.spring.taskexecutor;

import java.util.concurrent.atomic.AtomicInteger;

public class GreetingTask implements Runnable {

    private final Greeting greeting;

    private AtomicInteger count = new AtomicInteger(1);

    public GreetingTask(final Greeting greeting) {
        this.greeting = greeting;
    }

    @Override
    public void run() {
        count.incrementAndGet();
        String threadName = Thread.currentThread().getName();
        System.out.println(greeting.getMessage() + " executed by " + threadName + " count: " + count);
    }
}
