package util.concurrent.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Farrukhjon on 17-Sep-15.
 */
public class ExecutorsExample {

    public static void main(String[] args) {

        Runnable printTask = () -> {
            try {
                System.out.println("Thread id: " + Thread.currentThread().getId());
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        System.out.printf("cached ThreadPool example Execution ");
        //cached ThreadPool Example
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        executeMultiple(cachedThreadPool, printTask, 7);

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Single ThreadPool example Execution ");
        //single ThreadPool Example
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
        executeMultiple(singleThreadPool, printTask, 3);
    }

    private static void executeMultiple(ExecutorService executorService, Runnable r, int count) {
        for (int i = 0; i < count; i++) {
            executorService.execute(r); // execute method just replaces (new Thread(r)).start();
        }
        executorService.shutdown();
    }

}
