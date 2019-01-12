package org.farrukh.experiments.java.thread;

public class StateOfThread {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            boolean isNotInterrupted = false;
            while (isNotInterrupted) {
                Thread currentThread = Thread.currentThread();
                printState(currentThread);
            }
        });

        printState(thread);
        thread.start();

        printState(thread);

        thread.join();

        printState(thread);
    }

    private static void printState(Thread thread) {
        System.out.printf("State of the Thread %s is %s", thread.getName(), thread.getState());
    }

}
