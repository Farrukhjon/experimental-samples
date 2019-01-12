package org.farrukh.examples.java.concurrency;

import org.farrukh.examples.java.concurrency.domain.Message;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Producer implements Runnable {

    private final BlockingQueue<Message> queue;

    public Producer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Message message = new Message("Ali", "Vali", "Hello my friend!");
        try {
            while (!Thread.currentThread().isInterrupted()) {
                queue.put(message);
                System.out.println("A message: " + message + " has been produced from:" + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            return;
        }
    }
}
