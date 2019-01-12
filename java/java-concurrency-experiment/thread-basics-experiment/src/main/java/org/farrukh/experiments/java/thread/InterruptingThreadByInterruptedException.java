package org.farrukh.experiments.java.thread;

import java.util.concurrent.TimeUnit;

import static java.lang.String.format;

/**
 * Created by Farrukhjon on 23-Sep-15.
 */
class InterruptingThreadByInterruptedException {


    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            int i = 0;
            Thread currentThread = Thread.currentThread();
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    System.out.println(format("%s now is interrupted by %s; %s", currentThread.getName(), e, currentThread.getState()));
                    return;
                }
                System.out.println(format("%s is not interrupted; %s loop index = %s ", currentThread.getName(), currentThread.getState(), (++i)));
            }
        });

        printThreadState(thread);

        thread.start();

        TimeUnit.SECONDS.sleep(5); // sleep for 5 second and then interrupt someThread

        thread.interrupt();

        printThreadState(thread);

        thread.join();

        printThreadState(thread);
    }

    private static void printThreadState(Thread thread) {
        System.out.printf("State of %s is: %s\n", thread.getName(), thread.getState());
    }
}
