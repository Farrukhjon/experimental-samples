package org.farrukh.examples.spring.taskexecutor;

import org.springframework.core.task.TaskExecutor;

public class GreetingExecutor {

    private final TaskExecutor executor;

    public GreetingExecutor(final TaskExecutor executor) {
        this.executor = executor;
    }

    public void fireGreetingTask(final Greeting greeting) {
        executor.execute(new GreetingTask(greeting));
    }
}
