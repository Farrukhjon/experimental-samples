package org.farrukh.experiments.java.concurrent.collections.map;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentHashMapTest {

    @Test
    public void testCreateConcurrentHashMap() {
        ConcurrentHashMap<Integer, String> chm = new ConcurrentHashMap<>();

        ExecutorService threadPoolWriter = Executors.newCachedThreadPool();

        Random rnd = new Random();

        threadPoolWriter.execute(() -> {
            Integer rndId = rnd.ints(0, 9).findFirst().getAsInt();
            byte[] bytes = new byte[rndId];
            rnd.nextBytes(bytes);
            String rndName = new String(bytes);
            boolean empty = chm.isEmpty();
            while (empty) {
                System.out.printf("%s is putting key and value: %s, %s", Thread.currentThread().getName(), rndId, rndName);
                chm.putIfAbsent(rndId, rndName);
            }
        });

        Thread readerThread = new Thread(() -> {
            while (!chm.isEmpty()) {
                chm.entrySet();
                for (Integer rndId : chm.keySet()) {
                    String rndName = chm.get(rndId);
                    chm.remove(rndId);

                    System.out.printf("\n%s %s", rndId, rndName);
                }
            }
        });

        readerThread.start();

        try {
            readerThread.join();
        } catch (InterruptedException e) {

        }

        threadPoolWriter.shutdown();


    }
}
