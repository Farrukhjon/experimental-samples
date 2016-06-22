package org.farrukh.examples.spring.batch.reader;

import org.farrukh.examples.spring.batch.domain.Greeting;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.FixedLengthTokenizer;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.core.io.ClassPathResource;

public class GreetingFlatFileItemReader extends FlatFileItemReader<Greeting> {

    public GreetingFlatFileItemReader() {
        setResource(new ClassPathResource("greeting.txt"));
        DefaultLineMapper<Greeting> lineMapper = new DefaultLineMapper<>();
        FixedLengthTokenizer lineTokenizer = new FixedLengthTokenizer();
        lineTokenizer.setNames(new String[]{"ID", "MESSAGE"});
        lineTokenizer.setColumns(new Range[]{new Range(1, 2), new Range(3, 12)});
        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(new GreetingFieldSetMapper());
        setLineMapper(lineMapper);
    }
}
