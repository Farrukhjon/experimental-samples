package org.farrukh.examples.cucumber.groovy

import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks

/**
 * Created by Farrukhjon on 6/4/15.
 */

this.metaClass.mixin(Hooks)
this.metaClass.mixin(EN)

def calculator
def result

Given(~/^The positive numbers (\d+) and (\d+)$/) { int arg1, int arg2 ->
    calculator  = new Calculator(a: arg1, b: arg2)
}
When(~/^I call add method$/) { ->
    result = calculator.add()
}

Then(~/^It should return (\d+)$/) { int arg1 ->
    assert result == arg1
}
