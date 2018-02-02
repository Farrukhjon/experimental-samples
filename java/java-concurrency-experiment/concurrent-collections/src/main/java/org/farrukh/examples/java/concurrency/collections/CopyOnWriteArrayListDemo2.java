/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.examples.java.concurrency.collections;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CopyOnWriteArrayListDemo2 {

    public static void main(String[] args) {

        CopyOnWriteArrayList<Integer> data = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10; i++) {
            data.add(i);
        }

        int nThreads = 7;
        ExecutorService es = Executors.newFixedThreadPool(nThreads);

        for (int i = 0; i < nThreads; i++) {
            es.execute(new Worker(data));
        }

        es.shutdown();


    }


    private static class Worker implements Runnable {

        private List<Integer> data;

        public Worker(List<Integer> data) {
            this.data = data;
        }

        @Override
        public void run() {
            Iterator<Integer> iterator = data.iterator();
            while (iterator.hasNext()) {
                Integer item = iterator.next();
                System.out.printf("\nItem: %s read by: %s", item, Thread.currentThread().getName());
                System.out.printf("\ndata: %s ", data);
                int nextInt = new Random().nextInt(10);
                data.add(nextInt);

                data.remove(item);

                if(data.size() > 30) {
                    return;
                }
            }
        }
    }


}
