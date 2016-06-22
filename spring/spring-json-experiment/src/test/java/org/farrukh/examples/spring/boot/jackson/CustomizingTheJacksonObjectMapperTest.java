package org.farrukh.examples.spring.boot.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.farrukh.examples.spring.boot.jackson.domain.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Farrukhjon on 03-Oct-15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class CustomizingTheJacksonObjectMapperTest {

    @Autowired
    ObjectMapper mapper;

    @Test
    public void testCustomizingTheJacksonObjectMapperTest() {
        Person person = new Person();
        person.setFirstName("Aliev");
        person.setName("Vali");
        person.setLastName("Samievich");
        person.setBirthDate(new Date());

        try {
            String json = mapper.writeValueAsString(person);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        assertNotNull(mapper);
    }

}
