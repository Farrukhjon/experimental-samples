package org.farrukh.experiments.java.concurrency.basic.pc;

import org.farrukh.experiments.java.concurrency.basic.pc.DataConsumer;
import org.farrukh.experiments.java.concurrency.basic.pc.DataProducer;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class ProducerConsumerTest {

    @Test
    public void test() {

        Queue<Integer> queue = new ArrayDeque<>(10);

        DataProducer producer = new DataProducer(queue);
        DataConsumer consumer = new DataConsumer(queue);

        for (int i = 0; i < 17; i++) {
            Thread pt = new Thread(producer);
            pt.start();
            Thread ct = new Thread(consumer);
            ct.start();
        }

        try {
            TimeUnit.SECONDS.sleep(7);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
