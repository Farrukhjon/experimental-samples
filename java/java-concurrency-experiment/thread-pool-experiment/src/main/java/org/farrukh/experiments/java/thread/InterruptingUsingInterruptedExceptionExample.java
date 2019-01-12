package org.farrukh.experiments.java.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by Farrukhjon on 23-Sep-15.
 */
class InterruptingUsingInterruptedExceptionExample extends Thread {


    public static void main(String[] args) throws InterruptedException {

        InterruptingUsingInterruptedExceptionExample interruptedException = new InterruptingUsingInterruptedExceptionExample();
        interruptedException.start();
        TimeUnit.SECONDS.sleep(5); // sleep for 3 second and then interrupt someThread
        interruptedException.interrupt();
    }


    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println(getName() + " now is interrupted ");
                return;
            }
            System.out.println(getName() + " is not interrupted, " + "loop index = " + i);
        }
    }
}
