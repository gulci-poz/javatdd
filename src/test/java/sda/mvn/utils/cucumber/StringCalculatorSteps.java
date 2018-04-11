package sda.mvn.utils.cucumber;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import sda.mvn.utils.StringCalculator;

public class StringCalculatorSteps {

    private String value;

    private int result;

    private StringCalculator stringCalculator;

    @Given("^I initialize stringCalculator$")
    public void I_initialize_string_calculator() {
        this.stringCalculator = new StringCalculator();
    }

    @And("^I pass (.*) value$")
    public void I_pass_single_number_value(String text) {
        this.value = text;
    }

    @When("^I trigger calculate function$")
    public void I_trigger_calculate_function() {
        this.result = stringCalculator.sumString(value);
    }

    @Then("^I get (.*) as a result$")
    public void I_get_5_as_a_result(int passedResult) {
        Assert.assertEquals(passedResult, this.result);
    }

    @And("^I pass value null$")
    public void I_pass_null_value() {
        this.value = null;
    }
}
