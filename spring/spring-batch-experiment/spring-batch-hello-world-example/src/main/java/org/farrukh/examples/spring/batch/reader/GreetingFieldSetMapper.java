package org.farrukh.examples.spring.batch.reader;

import org.farrukh.examples.spring.batch.domain.Greeting;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class GreetingFieldSetMapper implements FieldSetMapper<Greeting> {

    @Override
    public Greeting mapFieldSet(final FieldSet fieldSet) throws BindException {
        Greeting greeting = new Greeting();
        greeting.setId(fieldSet.readInt("ID"));
        greeting.setMessage(fieldSet.readString("message"));
        return greeting;
    }

}
