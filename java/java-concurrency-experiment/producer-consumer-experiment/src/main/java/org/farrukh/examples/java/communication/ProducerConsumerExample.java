package communication;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ProducerConsumerExample {

    private static class Producer implements Runnable {

        private final Queue<Integer> queue;

        private Producer(final Queue<Integer> queue) {
            this.queue = queue;
        }

        private void produce() {
            synchronized (queue) {
                int elementValue = new Random().nextInt(10);
                if (queue.isEmpty()) {
                    queue.add(elementValue);
                    System.out.printf("%s %s", "Produced value is: ", elementValue);
                    System.out.println();
                }
                queue.notifyAll();
            }
        }

        @Override
        public void run() {
            produce();
        }
    }

    private static class Consumer implements Runnable {

        private final Queue<Integer> queue;

        private Consumer(final Queue<Integer> queue) {
            this.queue = queue;
        }

        private void consume() {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Integer value = queue.poll();
                System.out.printf("%s %s", "Consumed value is: ", value);
                System.out.println();
            }
        }

        @Override
        public void run() {
            consume();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        final Queue<Integer> queue = new ConcurrentLinkedQueue<>();
        ExecutorService executorService = Executors.newFixedThreadPool(7);
        for (int i = 0; i < 10; i++) {
            executorService.submit(new Producer(queue));
            executorService.submit(new Consumer(queue));
        }
        executorService.awaitTermination(1, TimeUnit.SECONDS);
        executorService.shutdown();
    }

}
