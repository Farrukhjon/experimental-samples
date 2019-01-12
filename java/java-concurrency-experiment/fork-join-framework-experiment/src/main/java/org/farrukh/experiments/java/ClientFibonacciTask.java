package org.farrukh.experiments.java;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ClientFibonacciTask {

    public static void main(String[] args) {
        ForkJoinPool pool = ForkJoinPool.commonPool();

        int num = 10;
        Long result = pool.invoke(new FibonacciTask(num));

        System.out.printf("Fibonacci number for %s is %s", num, result);

    }

    private static class FibonacciTask extends RecursiveTask<Long> {

        private final int num;

        FibonacciTask(int num) {
            this.num = num;
        }

        @Override
        protected Long compute() {
            if (num <= 1)
                return (long) num;
            FibonacciTask f1 = new FibonacciTask(num - 1);
            f1.fork(); // push to work queue
            FibonacciTask f2 = new FibonacciTask(num - 2);
            Long compute = f2.compute();
            Long join = f1.join();
            return compute + join;
        }
    }
}
