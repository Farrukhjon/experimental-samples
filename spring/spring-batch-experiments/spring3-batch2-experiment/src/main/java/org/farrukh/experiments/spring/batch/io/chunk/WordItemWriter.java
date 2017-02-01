package org.farrukh.experiments.spring.batch.io.chunk;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class WordItemWriter implements ItemWriter<String>{

    @Override
    public void write(List<? extends String> items) throws Exception {
        System.out.println("-----writing-----");
        for (String item : items) {
            System.out.println(item);
        }
    }

}
