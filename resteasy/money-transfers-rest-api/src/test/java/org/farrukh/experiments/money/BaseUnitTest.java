package org.farrukh.experiments.money;

import org.junit.Before;
import org.mockito.MockitoAnnotations;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.StringReader;
import java.io.StringWriter;

public class BaseUnitTest {

    @Before
    public void initMock() {
        MockitoAnnotations.initMocks(this);
    }

    protected final <T> String convertToStrXml(T account, Class<T> clazz) throws JAXBException {
        StringWriter writer = new StringWriter();
        JAXBContext.newInstance(clazz).createMarshaller().marshal(account, writer);
        return writer.toString();
    }

    protected final <T> T convertStrXmlToEntity(String account, Class<T> clazz) throws JAXBException {
        Object entity = JAXBContext.newInstance(clazz).createUnmarshaller().unmarshal(new StringReader(account));
        return clazz.cast(entity);
    }
}
