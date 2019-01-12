/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.examples.java.concurrency.collections;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

public class CopyOnWriteArrayListDemo {

    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> numbers = new CopyOnWriteArrayList<>();

        new Thread(new Producer(numbers)).start();
        new Thread(new Consumer(numbers)).start();

    }

    private static class Producer implements Runnable {

        private final CopyOnWriteArrayList<Integer> numbers;

        private Producer(final CopyOnWriteArrayList<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                try {
                    numbers.add(i);
                    System.out.println(i + " is added to the numbers");
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private static class Consumer implements Runnable {

        private final CopyOnWriteArrayList<Integer> numbers;

        public Consumer(final CopyOnWriteArrayList<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public void run() {
            for (int i = 0; i < numbers.size(); i++) {
                Integer number = numbers.get(i);
                try {
                    System.out.println(number + " is gotten from numbers");
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
