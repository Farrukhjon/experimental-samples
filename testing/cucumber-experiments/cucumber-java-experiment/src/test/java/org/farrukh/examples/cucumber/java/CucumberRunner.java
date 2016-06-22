package org.farrukh.examples.cucumber.java;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@CucumberOptions(features = "classpath:examples.feature")
@RunWith(value = Cucumber.class)
public class CucumberRunner {
}
