package util.concurrent.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Farrukhjon on 17-Sep-15.
 */
public class ExecutorServiceExample {

    private static Runnable printTask = () -> {
        System.out.println("Printed from thread: " + Thread.currentThread().getId());
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };

    public static void main(String[] args) {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        ExecutorService fixedThreadExecutor = Executors.newFixedThreadPool(10);
        ExecutorService scheduledThreadExecutor = Executors.newScheduledThreadPool(10);
        //runInLoop(singleThreadExecutor);
        //runInLoop(fixedThreadExecutor);
        runInLoop(scheduledThreadExecutor);
    }

    private static void runInLoop(ExecutorService executor) {
        for (int i = 0; i < 10; i++) {
            executor.execute(printTask);
        }
        executor.shutdown();
    }
}
