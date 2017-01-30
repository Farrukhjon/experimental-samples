package org.farrukh.examples.spring.batch.writer;

import org.farrukh.examples.spring.batch.domain.Greeting;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.core.io.ClassPathResource;

public class GreetingFlatFileItemWriter extends FlatFileItemWriter<Greeting> {

    public GreetingFlatFileItemWriter() {
        setResource(new ClassPathResource("newGreeting.txt"));
    }

}
