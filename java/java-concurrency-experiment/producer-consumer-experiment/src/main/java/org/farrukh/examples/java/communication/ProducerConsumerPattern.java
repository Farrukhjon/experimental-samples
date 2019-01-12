package communication;

import java.util.Queue;

public class ProducerConsumerPattern {

    public static void main(String[] args) {

    }

    private Object lock = new Object();

    class Producer {

        private final Queue<Double> queue;

        Producer(final Queue<Double> queue) {
            this.queue = queue;
        }

        public void produce() {
            synchronized (lock) {
                boolean someCondition = false;
                if (!someCondition) {
                    double someData = Math.random();
                    queue.add(someData);
                    someCondition = true;
                }
                lock.notifyAll();
            }
        }

    }

    class Consumer {

        private final Queue<Double> queue;

        Consumer(final Queue<Double> queue) {
            this.queue = queue;
        }

        public void consume() throws InterruptedException {
            synchronized (lock) {
                boolean noElement = queue.isEmpty();
                while (noElement) {
                    lock.wait();
                }
                Double poll = queue.poll();
            }
        }

    }
}

