package sda.mvn.bank.cucumber;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import sda.mvn.bank.Bank;
import sda.mvn.bank.BankUser;

public class BankSteps {

    private Bank bank;

    private BankUser bankUser;

    private boolean userInsertResult;

    @Given("^I instantiate Bank$")
    public void iInstantiateBank() {
        bank = new Bank();
    }

    @And("^I create BankUser with (.*) and (.*)$")
    public void iCreateBankUserWithNameAndPesel(String name, String pesel) {
        bankUser = new BankUser(name, pesel);
    }

    @When("^I add BankUser to Bank$")
    public void iAddBankUserToBank() {
        userInsertResult = bank.addBankUser(bankUser);
    }

    @Then("^BankUser is present in Bank$")
    public void bankuserIsPresentInBank() {
        Assert.assertTrue(userInsertResult);
        Assert.assertEquals(1, bank.numberOfUsers());
    }
}
