package util.concurrent.threadFactory;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class ExecutorsDefaultThreadFactoryDemo {

    public static void main(String[] args) {
        ThreadFactory defaultThreadFactory = Executors.defaultThreadFactory();

        final Runnable task = () -> {
            while (true) {
                System.out.println(new Date());
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    System.out.println("Thread has been interrupted");
                    return;
                }
            }
        };

        final Thread newThread = defaultThreadFactory.newThread(task);

        newThread.start();

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        newThread.interrupt();
    }

}
