package org.farrukh.examples.spring.taskexecutor;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Test class for experimenting using ThreadPoolTaskExecutor to execute GreetingTask by GreetingExecutor.
 */
public class ThreadPoolTaskExecutorTest extends BaseTest {

    @Autowired
    GreetingExecutor greetingExecutor;

    @Test
    public void test() {
        Greeting greeting = new Greeting();
        greeting.setMessage("Hello world!");

        for (int i = 0; i < 10; i++) {
            greetingExecutor.fireGreetingTask(greeting);
        }

    }

}
