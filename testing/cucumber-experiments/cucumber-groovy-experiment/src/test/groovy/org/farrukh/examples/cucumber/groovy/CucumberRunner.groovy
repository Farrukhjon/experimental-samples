package org.farrukh.examples.cucumber.groovy

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

/**
 * Created by Farrukhjon on 6/4/15.
 */

/**
 * Driver for all acceptance tests.
 */
@CucumberOptions(strict = false,
        tags = ['~@optional'], // by default do not run the optional tests
        plugin = ['pretty', 'html:build/reports/acceptanceTests'],
        monochrome = true)
@RunWith(Cucumber)
class CucumberRunner {
}
