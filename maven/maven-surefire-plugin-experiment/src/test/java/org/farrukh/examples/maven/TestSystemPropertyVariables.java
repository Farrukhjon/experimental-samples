package org.farrukh.examples.maven;

import static org.junit.Assert.assertEquals;

import org.farrukh.examples.maven.category.FastTests;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(FastTests.class)
public class TestSystemPropertyVariables {
    
    @Test
    public void testReadingASystemPropertyProvidedByMavenSurefireConfigProperty() throws Exception {
        String enableIT = System.getProperty("enableIT");
        assertEquals("true", enableIT);
    }

}
