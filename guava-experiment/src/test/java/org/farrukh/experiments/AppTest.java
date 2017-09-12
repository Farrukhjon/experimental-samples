package org.farrukh.experiments;

import com.google.common.base.Stopwatch;
import org.junit.Test;

import java.util.concurrent.TimeUnit;


public class AppTest {

    @Test
    public void testStopWatch() throws Exception {
        Stopwatch stopwatch = new Stopwatch().start();

        Thread.sleep(5 * 1000);

        stopwatch.stop();

        long elapsedTime = stopwatch.elapsedTime(TimeUnit.SECONDS);

        System.out.printf("Execution time in %s seconds", elapsedTime);
        System.out.printf("Execution time in %s seconds", stopwatch);


        Stopwatch start = new Stopwatch().start();

        Thread.sleep(7 * 1000);

        start.stop();

        long elapsedTime1 = start.elapsedTime(TimeUnit.SECONDS);

        System.out.println();

        System.out.printf("Execution time in %s seconds", elapsedTime1);
        System.out.printf("Execution time in %s seconds", start);



    }
}
