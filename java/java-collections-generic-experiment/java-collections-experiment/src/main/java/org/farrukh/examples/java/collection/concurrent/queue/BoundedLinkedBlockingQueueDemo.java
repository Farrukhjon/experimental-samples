package org.farrukh.examples.java.collection.concurrent.queue;

import java.util.concurrent.LinkedBlockingQueue;

public class BoundedLinkedBlockingQueueDemo {

    public static void main(String[] args) {

        int capacity = 10;
        LinkedBlockingQueue<Integer> lbq = new LinkedBlockingQueue<>(capacity);

        testingAddMethod(capacity, lbq);
        //testingOfferMethod(capacity, lbq);
        //testingPutMethod(capacity, lbq);

        print(lbq);

    }

    private static void print(final LinkedBlockingQueue<Integer> lbq) {
        System.out.printf("queue: %-30s remainingCapacity: %-2s size: %s\n", lbq, lbq.remainingCapacity(), lbq.size());
    }

    private static void testingAddMethod(final int capacity, final LinkedBlockingQueue<Integer> lbq) {
        for (int i = 0; i <= capacity; i++) {
            print(lbq);
            try {
                lbq.add(i);
            } catch (IllegalStateException e) {
                System.out.println(e);
            }
        }
    }

    private static void testingOfferMethod(final int capacity, final LinkedBlockingQueue<Integer> lbq) {
        for (int i = 0; i <= capacity; i++) {
            print(lbq);
            lbq.offer(i);
        }
    }

    private static void testingPutMethod(final int capacity, final LinkedBlockingQueue<Integer> lbq) {
        for (int i = 0; i <= capacity; i++) {
            print(lbq);
            try {
                lbq.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
