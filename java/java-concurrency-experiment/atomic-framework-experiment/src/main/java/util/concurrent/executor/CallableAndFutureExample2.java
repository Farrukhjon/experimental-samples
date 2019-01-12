package util.concurrent.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Farrukhjon on 17-Sep-15.
 */
public class CallableAndFutureExample2 {

    static class CountTask implements Callable<Integer> {

        private final int count;

        CountTask(final int count) {
            this.count = count;
        }

        @Override
        public Integer call() throws Exception {
            int c =+ count;

            return c;
        }
    }

    static class CountExecutor {

        ExecutorService executorService;

        public CountExecutor() {
            executorService = Executors.newFixedThreadPool(7);
        }

        public Integer execute(final CountTask task) {
            Integer result = null;
            Future<Integer> future = executorService.submit(task);
            try {
                result = future.get();
                System.out.println("Result after future get: " + result);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            return result;
        }

        public void stop() {
            executorService.shutdown();
        }
    }

    public static void main(String[] args) {
        int sum = 0;
        CountExecutor countExecutor = new CountExecutor();
        for (int i = 0; i < 10; i++) {
            CountTask task = new CountTask(sum);
            countExecutor.execute(task);
        }
        countExecutor.stop();
    }
}
