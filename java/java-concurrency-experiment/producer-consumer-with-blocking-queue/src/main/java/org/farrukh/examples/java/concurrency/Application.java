package org.farrukh.examples.java.concurrency;

import org.farrukh.examples.java.concurrency.domain.Message;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Application {

    public static void main(String[] args) {
        BlockingQueue<Message> queue = new ArrayBlockingQueue<>(100);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        Thread threadProducer = new Thread(producer);
        Thread threadConsumer = new Thread(consumer);

        threadProducer.start();
        threadConsumer.start();

        try {
            TimeUnit.SECONDS.sleep(5);
            threadProducer.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
