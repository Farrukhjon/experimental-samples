package org.farrukh.experiment.formatting;

import org.junit.Assert;
import org.junit.Test;


public class AppTest {

    private App sut = new App();

    @Test
    public void testToCommaSeparatedDecimalFormatting() {
        String strNumber = "35634646";
        String formatted = sut.toCommaSeparated(strNumber);
        Assert.assertEquals("35,634,646", formatted);
    }
}
