package org.farrukh.examples.spring.batch.processor;

import org.farrukh.examples.spring.batch.domain.Greeting;
import org.springframework.batch.item.ItemProcessor;

public class GreetingItemProcessor implements ItemProcessor<Greeting, Greeting> {

    @Override
    public Greeting process(final Greeting item) throws Exception {
        Greeting greeting = new Greeting();
        greeting.setMessage(item.getMessage().toUpperCase());
        return greeting;
    }
}
