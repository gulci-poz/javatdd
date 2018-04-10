package sda.mvn.utils.cucumber;

import cucumber.api.PendingException;
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

    @And("^I pass single number value$")
    public void I_pass_single_number_value() {
        this.value = "5";
    }

    @When("^I trigger calculate function$")
    public void I_trigger_calculate_function() {
        this.result = stringCalculator.sumString(value);
    }

    @Then("^I get 5 as a result$")
    public void I_get_5_as_a_result() {
        Assert.assertEquals(5, this.result);
    }

    @And("^I pass null value$")
    public void I_pass_null_value() {
        this.value = null;
    }

    @Then("^I get 0 as a result$")
    public void I_get_0_as_a_result() {
        Assert.assertEquals(0, this.result);
    }

    @And("^I pass an empty value$")
    public void I_pass_an_empty_value() {
        this.value = "";
    }

    @And("^I pass multiple values$")
    public void iPassMultipleValues() {
        this.value = "3,4,5";
    }

    @Then("^I get 12 as a result$")
    public void iGetAsAResult() {
        Assert.assertEquals(12, this.result);
    }

    @And("^I pass multiple values containing multiple spaces between them$")
    public void iPassMultipleValuesContainingMultipleSpacesBetweenThem() {
        this.value = "3, 4,   5";
    }

    @And("^I pass multiple values containing multiple delimiters side-by-side$")
    public void iPassMultipleValuesContainingMultipleDelimitersSideBySide() {
        this.value = "3, 4,,; 5";
    }

    @And("^I pass multiple values containing multiple delimiters side-by-side with multiple whitespaces$")
    public void iPassMultipleValuesContainingMultipleDelimitersSideBySideWithMultipleWhitespaces() {
        this.value = "3,     4   ,,; 5";
    }
}
