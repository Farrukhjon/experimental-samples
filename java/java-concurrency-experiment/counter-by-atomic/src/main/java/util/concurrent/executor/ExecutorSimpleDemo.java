package util.concurrent.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorSimpleDemo {

    public static void main(String[] args) {

        ThreadPoolExecutor poolExecutor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {

            poolExecutor.execute(() ->
                                 {
                                     try {
                                         TimeUnit.SECONDS.sleep(1);
                                     } catch (InterruptedException e) {
                                         e.printStackTrace();
                                     }
                                     System.out.println(Thread.currentThread()
                                                              .getName());
                                 }
            );
        }
        poolExecutor.shutdown();
    }
}
