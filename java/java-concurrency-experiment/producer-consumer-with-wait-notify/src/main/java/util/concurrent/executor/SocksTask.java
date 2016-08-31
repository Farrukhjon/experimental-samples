package util.concurrent.executor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

public class SocksTask implements Callable<Socks> {

    private final Account account;

    private final int port;

    public SocksTask(final Account account, final int port) {
        this.account = account;
        this.port = port;
    }

    @Override
    public Socks call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        Socks socks = new Socks(account.getHost(), port);
        return socks;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        LinkedBlockingQueue<Socks> socksPool = new LinkedBlockingQueue<>(10);
        LinkedBlockingQueue<Integer> portPool = new LinkedBlockingQueue<>(10);
        for (int i = 0; i < 10; i++) {
            portPool.offer(i);
        }

        ExecutorService executor = Executors.newCachedThreadPool();
        List<Account> accounts = Arrays.asList(new Account("host1"),new Account("host2"), new Account("host3"));


        List<Future<Socks>> futures = new ArrayList<>();

        for (Account account : accounts) {
            Future<Socks> future = executor.submit(new SocksTask(account, portPool.poll()));
            futures.add(future);
        }

        for (Future<Socks> future : futures) {
            Socks socks = future.get();
            socksPool.offer(socks);
        }

        System.out.println(socksPool);

        executor.shutdown();

    }

}
