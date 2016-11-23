package org.farrukh.example.sprin;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class OutputCaptureRuleDemoTest {
    
    @Rule
    public OutputCapture outputCapture = new OutputCapture();
    
	@Test
	public void shouldCaptureStdOutMesaage() {
	    System.out.println("Hello world output");
	    String expectedOutputCaptureValue = "Hello world output";
	    assertThat(outputCapture.toString(), Matchers.containsString(expectedOutputCaptureValue));
	}

}
