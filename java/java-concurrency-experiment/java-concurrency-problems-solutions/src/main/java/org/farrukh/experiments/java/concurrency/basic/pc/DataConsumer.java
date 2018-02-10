package org.farrukh.experiments.java.concurrency.basic.pc;

import java.util.Queue;

public class DataConsumer implements Runnable {

    private final Queue<Integer> queue;

    public DataConsumer(Queue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        String thread = Thread.currentThread().getName();
        synchronized (queue) {
            while (queue.isEmpty()) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    return;
                }
            }
            System.out.printf("Consumer: %s started consuming...\n", thread);
            Integer item = queue.poll();
            System.out.printf("Consumer: %s has consumed value: %s \n", thread, item);
        }
    }

}
