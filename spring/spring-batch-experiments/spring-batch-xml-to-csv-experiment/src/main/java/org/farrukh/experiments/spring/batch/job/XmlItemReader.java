package org.farrukh.experiments.spring.batch.job;

import org.farrukh.experiments.spring.batch.model.Xml;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

public class XmlItemReader extends StaxEventItemReader<Xml> {

    public static final String DATA_TRADES_XML = "data/trades.xml";

    public XmlItemReader(Jaxb2Marshaller jaxb2Marshaller) {
        setUnmarshaller(jaxb2Marshaller);
        setFragmentRootElementName("trade");
        setResource(new ClassPathResource(DATA_TRADES_XML));
    }
}
