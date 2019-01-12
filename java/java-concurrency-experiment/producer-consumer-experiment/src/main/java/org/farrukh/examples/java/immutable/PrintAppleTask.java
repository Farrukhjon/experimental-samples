package immutable;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class PrintAppleTask implements Runnable {

    private final List<Apple> apples;

    public PrintAppleTask(final List<Apple> apples) {
        this.apples = apples;
    }

    @Override
    public void run() {
        System.out.printf("%s printing started \n", Thread.currentThread()
                                                          .getName());
        for (Apple apple : apples) {
            System.out.println(apple);
        }
        System.out.printf("%s printing finished \n", Thread.currentThread()
                                                           .getName());
    }
}
