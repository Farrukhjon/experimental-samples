package org.farrukh.experiments.java.concurrency.basic.management;

import org.junit.Test;

public class CreateAndRunThread {

    @Test
    public void testCreateThreadByPassingRunnable() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                printCurrentThreadInfo();
            }
        }).start();
    }

    @Test
    public void testCreateThreadByExtending() {
        new TestTask().start();
    }

    @Test
    public void testCreateThreadByLambda() {
        new Thread(() ->
                printCurrentThreadInfo()
        ).start();
    }


    private void printCurrentThreadInfo() {
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        long id = currentThread.getId();
        Thread.State state = currentThread.getState();
        System.out.printf("Name: %s, Id: %s, State: %s", name, id, state);
    }

    private class TestTask extends Thread {
        @Override
        public void run() {
            String name = this.getName();
            long id = this.getId();
            Thread.State state = this.getState();
            System.out.printf("Name: %s, Id: %s, State: %s", name, id, state);
        }
    }
}
