package org.farrukh.examples.java.concurrency;

import org.farrukh.examples.java.concurrency.domain.Message;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private final BlockingQueue<Message> queue;

    public Consumer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Message message = queue.take();
            System.out.println("The Consumed message is: " + message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
