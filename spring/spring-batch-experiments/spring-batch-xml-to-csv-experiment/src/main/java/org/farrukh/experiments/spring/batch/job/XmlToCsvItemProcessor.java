package org.farrukh.experiments.spring.batch.job;

import org.farrukh.experiments.spring.batch.model.Csv;
import org.farrukh.experiments.spring.batch.model.Xml;
import org.springframework.batch.item.ItemProcessor;

public class XmlToCsvItemProcessor implements ItemProcessor<Xml, Csv> {

    @Override
    public Csv process(Xml xml) throws Exception {
        Csv csv = new Csv();
        csv.setIsin(xml.getIsin());
        csv.setPrice(xml.getPrice() * 2);
        csv.setQuantity(xml.getQuantity());
        csv.setCustomer(xml.getCustomer());
        return csv;
    }

}
