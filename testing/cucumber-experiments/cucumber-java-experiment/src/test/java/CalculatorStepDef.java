import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.farrukh.examples.cucumber.java.Calculator;

/**
 * Created by Farrukhjon on 25-Sep-15.
 */
public class CalculatorStepDef {

    private Calculator calculator;

    @Given("^Two integer (\\d+) and (\\d+)$")
    public void Two_integer_and(int arg1, int arg2) throws Throwable {
        calculator = new Calculator();
        calculator.add(arg1, arg2);
    }

    @Then("^The (\\d+) is returned$")
    public void The_is_returned(int arg1) throws Throwable {
        assert arg1 == calculator.getResult();
    }
}
