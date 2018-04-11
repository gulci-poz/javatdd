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

    private boolean accountCreateResult;

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
        userInsertResult = bank.addBankUser(new BankUser(bankUser.getName(), bankUser.getPesel()));
    }

    @Then("^BankUser is present in Bank$")
    public void bankuserIsPresentInBank() {
        Assert.assertTrue(userInsertResult);
        Assert.assertEquals(1, bank.numberOfUsers());
    }

    @Then("^User is not present in bank$")
    public void userIsNotPresentInBank() {
        Assert.assertFalse(userInsertResult);
        Assert.assertEquals(1, bank.numberOfUsers());
    }

    @And("^I bind acount of type (.*) to BankUser$")
    public void iBindAcountOfTypeAccountToBankUser(String account) {
        accountCreateResult = bank.createAccountFor(bankUser, account);
    }

    @Then("^BankUser has BankAccount$")
    public void bankuserHasBankAccount() {
        Assert.assertTrue(accountCreateResult);
        Assert.assertEquals(1, bank.getAccountsOf(bankUser).size());
    }

    @Then("^BankAccount is not created$")
    public void bankaccountIsNotCreated() {
        Assert.assertFalse(accountCreateResult);
    }
}
