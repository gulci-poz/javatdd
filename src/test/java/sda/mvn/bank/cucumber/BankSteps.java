package sda.mvn.bank.cucumber;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.mockito.Mockito;
import sda.mvn.bank.Bank;
import sda.mvn.bank.BankAccount;
import sda.mvn.bank.BankDatabase;
import sda.mvn.bank.BankUser;

public class BankSteps {

    private Bank bank;

    private BankUser bankUser;

    private BankDatabase bankDatabase = new BankDatabase();

    private boolean userInsertResult;

    private boolean accountCreateResult;

    private boolean depositResult;

    @Given("^I mock BankDatabase for this case$")
    public void iMockBankDatabaseForThisCase() {
        bankDatabase = Mockito.mock(BankDatabase.class);
        Mockito.when(bankDatabase.addBankUser(Mockito.any())).then(e -> true);
        Mockito.when(bankDatabase.createAccountFor(Mockito.any(), Mockito.anyString()))
                .then(e -> true);
        Mockito.when(bankDatabase.getAccountOfType(Mockito.anyString()))
                .then(e -> BankAccount.instanceOf(null, 1000));
        Mockito.when(bankDatabase.deposit(Mockito.anyString(), Mockito.anyInt()))
                .then(e -> true);
    }

    @And("^I instantiate Bank$")
    public void iInstantiateBank() {
        bank = new Bank(bankDatabase);
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

    @Then("^Second BankAccount of specific type is not created$")
    public void secondBankAccountOfSpecificTypeIsNotCreated() {
        Assert.assertEquals(1, bank.getAccountsOf(bankUser).size());
    }

    @And("^I deposit (\\d+) to (.*) type$")
    public void iDepositAmountToAccountType(int amount, String account) {
        depositResult = bank.deposit(account, amount);
    }

    @Then("^BankAccount of type (.*) has (\\d+) balance$")
    public void bankaccountOfTypeAccountHasBalanceAmount(String account, int amount) {
        Assert.assertTrue(depositResult);
        Assert.assertEquals(amount, bank.getAccountOfType(account).getAmount());
    }
}
