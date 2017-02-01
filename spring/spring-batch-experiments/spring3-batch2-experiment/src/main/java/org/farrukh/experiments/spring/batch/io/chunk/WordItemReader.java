package org.farrukh.experiments.spring.batch.io.chunk;

import java.util.Iterator;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class WordItemReader implements ItemReader<String> {

    private Iterator<String> iterator;

    public WordItemReader(List<String> sentence) {
        iterator = sentence.iterator();
    }

    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        System.out.println("-----reading-----");
        if (iterator.hasNext()) {
            return iterator.next();
        } else {
            return null;
        }
    }

}
