package util.concurrent.collection;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueExample {

    public static void main(String[] args) {

        BlockingQueue<String> queue = new ArrayBlockingQueue<>(1024);
        BlockingQueueProducer producer = new BlockingQueueProducer(queue);
        BlockingQueueConsumer consumer = new BlockingQueueConsumer(queue);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.setPriority(Thread.MAX_PRIORITY);
        consumerThread.setPriority(Thread.MIN_PRIORITY);

        producerThread.start();
        consumerThread.start();
    }

    private static class BlockingQueueConsumer implements Runnable {

        private BlockingQueue<String> blockingQueue;

        public BlockingQueueConsumer(BlockingQueue<String> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            try {
                System.out.println("blockingQueue.take(): " + blockingQueue.take());
                System.out.println("blockingQueue.take(): " + blockingQueue.take());
                System.out.println("blockingQueue.take(): " + blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private static class BlockingQueueProducer implements Runnable {

        private BlockingQueue<String> blockingQueue;

        public BlockingQueueProducer(BlockingQueue<String> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(5);
                blockingQueue.put("Lion");
                System.out.println("blockingQueue.put('Lion')");
                TimeUnit.SECONDS.sleep(1);
                blockingQueue.put("Crocodile");
                System.out.println("blockingQueue.put('Crocodile')");
                TimeUnit.SECONDS.sleep(2);
                blockingQueue.put("Jaguar");
                System.out.println("blockingQueue.put('Jaguar')");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
