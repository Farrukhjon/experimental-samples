package org.farrukh.experiments.spring.batch.job;

import org.farrukh.experiments.spring.batch.model.Csv;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.core.io.ClassPathResource;

public class XmlToCsvItemWriter extends FlatFileItemWriter<Csv> {

    public static final String DATA_TRADES_CSV = "data/trades.csv";
    public static final String HEADER = "isin,quantity,price,customer";

    public XmlToCsvItemWriter() {
        setResource(new ClassPathResource(DATA_TRADES_CSV));
        setHeaderCallback(writer -> writer.write(HEADER));
        DelimitedLineAggregator<Csv> lineAggregator = new DelimitedLineAggregator<>();
        BeanWrapperFieldExtractor<Csv> fieldExtractor = new BeanWrapperFieldExtractor<>();
        fieldExtractor.setNames(new String[]{"isin", "quantity", "price", "customer"});
        lineAggregator.setFieldExtractor(fieldExtractor);
        setLineAggregator(lineAggregator);
    }
}
