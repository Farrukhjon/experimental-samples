package util.concurrent.executor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Farrukhjon on 17-Sep-15.
 */
public class ThreadPoolExecutorExample2 implements Runnable {

    private static AtomicInteger counter = new AtomicInteger();

    private final int taskId;

    public ThreadPoolExecutorExample2(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BlockingQueue<Runnable> queue = new LinkedBlockingDeque<>(10);

        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                int currentCount = counter.getAndIncrement();
                System.out.println("Creating new thread:" + currentCount);
                return new Thread(r, "theard" + currentCount);
            }
        };

        RejectedExecutionHandler rejectedHandler = new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                ThreadPoolExecutorExample2 threadPoolExecutorExample = (ThreadPoolExecutorExample2) r;
                System.out.println("Rejected task with id: " + threadPoolExecutorExample.taskId);
            }
        };

        ThreadPoolExecutor executor = new ThreadPoolExecutor(7, 10, 1, TimeUnit.SECONDS, queue, threadFactory, rejectedHandler);

        for (int i = 0; i < 100; i++) {
            executor.execute(new ThreadPoolExecutorExample2(i));
        }

        executor.shutdown();
    }

}
