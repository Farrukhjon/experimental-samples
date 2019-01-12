package org.farrukh.examples.java.concurrency.immutable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ImmutableDemo {

    public static void main(String[] args) throws InterruptedException {
        List<Apple> apples = Arrays.asList(new Apple("green"), new Apple("red"), new Apple("yellow"));

        Thread thread1 = new Thread(new PrintAppleTask(apples));
        Thread thread2 = new Thread(new PrintAppleTask(apples));
        Thread thread3 = new Thread(new PrintAppleTask(apples));

        thread1.start();
        thread2.start();
        thread3.start();

        TimeUnit.SECONDS.sleep(1);

    }


}
