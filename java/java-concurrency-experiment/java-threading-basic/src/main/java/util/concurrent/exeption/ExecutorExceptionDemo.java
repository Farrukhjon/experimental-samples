package util.concurrent.exeption;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorExceptionDemo {

    public static void main(String[] args) {
        int count = 10;
        ExecutorService threadPool = Executors.newFixedThreadPool(count);

        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            futures.add(threadPool.submit(() -> {
                if (count % 2 == 1) {
                    throw new RuntimeException("Odd count: " + count);
                }
                System.out.printf("Name: %s count: %s \n", Thread.currentThread()
                                                                 .getName(), count);
                return count;
            }));
        }

        futures.forEach(future -> {
            try {
                Integer value = future.get();
                System.out.println(value);
            } catch (InterruptedException | ExecutionException e) {
                System.out.printf("Caused by: %s \n", e.getCause());
                System.out.printf("Is future canceled?: %s, Is future done? %s \n", future.isCancelled(), future.isDone());
            }
        });

        threadPool.shutdown();

    }

}
