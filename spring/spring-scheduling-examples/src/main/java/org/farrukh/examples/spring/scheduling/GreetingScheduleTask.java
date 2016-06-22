package org.farrukh.examples.spring.scheduling;

import org.springframework.scheduling.annotation.Scheduled;

public class GreetingScheduleTask {

    int count = 0;

    @Scheduled(fixedRate = 5000)
    public void sayHello() {
        count++;
        System.out.println("Hello World! " + count + " times");
    }

}
