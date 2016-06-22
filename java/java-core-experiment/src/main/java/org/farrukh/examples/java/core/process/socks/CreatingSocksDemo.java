package org.farrukh.examples.java.core.process.socks;

import org.farrukh.examples.java.core.process.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.lang.Runtime.getRuntime;

public class CreatingSocksDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final ExecutorService executor = Executors.newFixedThreadPool(getRuntime().availableProcessors());

        final Account account = new Account("root", "Df7t59Fgcm", "37.220.38.105", 22);

        List<Future<Optional<Socks>>> list = new ArrayList<>();
        for (int portNum = 9200; portNum < 9210; portNum++) {
            Future<Optional<Socks>> future = executor.submit(new SocksTask("127.0.0.1", portNum, account));
            list.add(future);
        }

        list.stream()
            .forEach(optionalFuture -> {
                try {
                    final Optional<Socks> socksOptional = optionalFuture.get();
                    if (socksOptional.isPresent()) {
                        final Socks socks = socksOptional.get();
                        System.out.println(socks);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            });
        executor.shutdown();
    }

}
