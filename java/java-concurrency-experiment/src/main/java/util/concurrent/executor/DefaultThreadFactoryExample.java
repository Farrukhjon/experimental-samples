package util.concurrent.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class DefaultThreadFactoryExample {

    public static void main(String[] args) {
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        for (int i = 0; i < 10; i++) {
            final Thread t = threadFactory.newThread(() ->
                    System.out.println("Current running thread name is: " + Thread.currentThread().getName()));
            t.start();
        }
    }

}
