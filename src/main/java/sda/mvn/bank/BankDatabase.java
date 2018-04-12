package sda.mvn.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankDatabase {

    private Map<BankUser, List<BankAccount>> database;

    public BankDatabase() {
        this.database = new HashMap<>();
    }

    public boolean addBankUser(BankUser bankUser) {
        if (database.containsKey(bankUser)) {
            return false;
        }

        int oldNumberOfUsers = numberOfUsers();

        database.put(bankUser, new ArrayList<>());

        return oldNumberOfUsers + 1 == numberOfUsers();
    }

    public boolean createAccountFor(BankUser bankUser, String accountType) {
        if (!database.containsKey(bankUser)) {
            return false;
        }

        BankAccount bankAccount = new BankAccount(accountType);
        int oldNumberOfAccounts = database.get(bankUser) != null ? database.get(bankUser).size() : 0;

        // amount may differ, we have to check only type
        if (!database.get(bankUser).contains(bankAccount)) {
            database.get(bankUser).add(new BankAccount(accountType));
        }

        return oldNumberOfAccounts + 1 == database.get(bankUser).size();
    }

    public List<BankAccount> getAccountsOf(BankUser bankUser) {
        return database.get(bankUser);
    }

    public int numberOfUsers() {
        return database.size();
    }

    public BankAccount getAccountOfType(String accountType) {
        return null;
    }

    public boolean deposit(String accountType, int amount) {
        throw new RuntimeException();
    }
}
