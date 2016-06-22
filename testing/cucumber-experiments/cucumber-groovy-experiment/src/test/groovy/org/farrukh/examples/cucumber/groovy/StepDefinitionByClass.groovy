package org.farrukh.examples.cucumber.groovy

import cucumber.api.java.Before
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

/**
 * Created by Farrukhjon on 6/4/15.
 */
class StepDefinitionByClass {

    class MyWorld {
        int result
        long factorial
        Calculator calculator
    }

    MyWorld world

    @Before
    void init() {
        world = new MyWorld(calculator: new Calculator())
        world.result = 0
        world.factorial = 0
    }

    /**
     * Each scenario must make sense
     * and be able to be executed independently
     * of any other scenario.
     */

    @Given('^The calculator$')
    void 'The_positive_number'() {
        world.calculator = new Calculator()
    }

    @When('^I call subtract method with (\\d+) and (\\d+)$')
    void 'I_call_subtract_method_with_and'(int a, int b) {
        world.result = world.calculator.subtract(a, b)
    }

    @Then('^It should return subtracted result (\\d+)$')
    void 'It_should_return_subtracted_result'(int arg1) {
        assert world.result == arg1
    }

    @Given('^calculate factorial on (\\d+) is called$')
    void 'calculate_factorial_on_is_called'(int arg1) {
        world.factorial = world.calculator.factorial(arg1)
    }

    @Then('^expected factorial is (\\d+)$')
    void 'expected_factorial_is_returned'(int arg1) {
        assert world.factorial == arg1
    }
}
