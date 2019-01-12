package org.farrukh.experiments.java.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class GracefullyStopThread {

    public static void main(String[] args) throws InterruptedException {

        int sleepInterval = 3;

        ControlSubThread worker = new ControlSubThread(sleepInterval);

        worker.start();

        TimeUnit.SECONDS.sleep(7);

        worker.stop();

    }

    public static class ControlSubThread implements Runnable {

        private Thread worker;
        private int interval = 100;
        private AtomicBoolean running = new AtomicBoolean(false);
        private AtomicBoolean stopped = new AtomicBoolean(true);


        public ControlSubThread(int sleepInterval) {
            interval = sleepInterval;
        }

        public void start() {
            worker = new Thread(this);
            worker.start();
        }

        public void stop() {
            running.set(false);
        }

        public void interrupt() {
            running.set(false);
            worker.interrupt();
        }

        boolean isRunning() {
            return running.get();
        }

        boolean isStopped() {
            return stopped.get();
        }

        public void run() {
            running.set(true);
            stopped.set(false);
            while (running.get()) {
                try {
                    Thread.sleep(interval);
                    System.out.println("Working...");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Thread was interrupted, Failed to complete operation");
                }
                // do something
            }
            stopped.set(true);
        }
    }

}
