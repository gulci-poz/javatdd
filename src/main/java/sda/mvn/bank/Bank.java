package sda.mvn.bank;

import java.util.List;

public class Bank {

    private BankDatabase bankDatabase;

    public Bank(BankDatabase bankDatabase) {
        this.bankDatabase = bankDatabase;
    }

    public boolean deposit(String accountType, int amount) {
        return bankDatabase.deposit(accountType, amount);
    }

    public boolean addBankUser(BankUser bankUser) {
        return bankDatabase.addBankUser(bankUser);
    }

    public boolean createAccountFor(BankUser bankUser, String accountType) {
        return bankDatabase.createAccountFor(bankUser, accountType);
    }

    public List<BankAccount> getAccountsOf(BankUser bankUser) {
        return bankDatabase.getAccountsOf(bankUser);
    }

    public int numberOfUsers() {
        return bankDatabase.numberOfUsers();
    }

    public BankAccount getAccountOfType(String accountType) {
        return bankDatabase.getAccountOfType(accountType);
    }
}
