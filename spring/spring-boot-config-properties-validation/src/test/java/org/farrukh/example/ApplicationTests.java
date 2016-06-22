package org.farrukh.example;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.boot.test.EnvironmentTestUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationTests {

    private final AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testInvalidValueOfSeatCountFromCarProperties() {
        appContext.register(Application.class);
        EnvironmentTestUtils.addEnvironment(appContext, "car.seatCount:0");
        exception.expect(BeanCreationException.class);
        exception.expectMessage("Invalid seat count");
        appContext.refresh();
    }

}
