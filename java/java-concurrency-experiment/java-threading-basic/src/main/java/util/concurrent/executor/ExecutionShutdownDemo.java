package util.concurrent.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutionShutdownDemo {

    public static void main(String[] args) {
        int count = 10;
        ExecutorService executor = Executors.newFixedThreadPool(count);
        List<Future<Integer>> futures = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Future<Integer> future = executor.submit(new PrintTask(i));
            futures.add(future);
        }

        futures.parallelStream()
               .forEach(future -> {
                   try {
                       Integer value = future.get();
                       TimeUnit.SECONDS.sleep(10);
                       System.out.printf("Value: %s \n", value);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   } catch (ExecutionException e) {
                       e.printStackTrace();
                   }
               });

        executor.shutdown();

     /*   try {
            executor.awaitTermination(1, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

    }

    private static class PrintTask implements Callable<Integer> {

        private final int count;

        public PrintTask(final int count) {
            this.count = count;
        }

        @Override
        public Integer call() throws Exception {
            String threadName = Thread.currentThread().getName();
            System.out.printf("Thread %s started working...\n", threadName);
            TimeUnit.SECONDS.sleep(2);
            System.out.printf("Thread %s ended working... \n", threadName);
            return count;
        }
    }
}
