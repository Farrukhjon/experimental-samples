package org.farrukh.examples.jmokit.mocking.mocked;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import mockit.Expectations;
import mockit.Mocked;

public class MockCDemoTest {

    @Mocked
    C c;

    @Test
    public void testC() throws Exception {
        new Expectations() {
            {
                c.sayHello();
                result = "Hi";
            }
        };
        
        ClassUnderTest cut = new ClassUnderTest(c);
        
        String greeting = cut.greeting();
        assertEquals("Hi world!", greeting);
    }

}
