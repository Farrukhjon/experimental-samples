package org.farrukh.examples.java.functional.optional;

import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;

public class OptionalDemo2 {

    public static void main(String[] args) {
        final LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
        for (int i = 0; i < 100; i++) {
            queue.offer(UUID.randomUUID().toString());
        }

        final String s = queue.stream().findAny().get();
        System.out.println(queue);
        System.out.println(s);
    }

}
