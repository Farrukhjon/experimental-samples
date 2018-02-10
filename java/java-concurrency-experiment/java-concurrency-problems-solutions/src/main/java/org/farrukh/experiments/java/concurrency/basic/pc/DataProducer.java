package org.farrukh.experiments.java.concurrency.basic.pc;

import java.util.Queue;
import java.util.Random;

public class DataProducer implements Runnable {

    private final Queue<Integer> queue;

    public DataProducer(Queue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        String thread = Thread.currentThread().getName();
        synchronized (queue) {
            System.out.printf("Thread: %s is starting... \n", thread);
            while (queue.isEmpty() || queue.size() <= 2) {
                Integer rnd = new Random().nextInt();
                boolean offered = queue.offer(rnd);
                if (offered) {
                    System.out.printf("Item: %s has been produced by %s \n", rnd, thread);
                }
                queue.notifyAll();
            }

        }
    }

}
