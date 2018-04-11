package sda.mvn.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {

    private Map<BankUser, List<BankAccount>> database;

    public Bank() {
        this.database = new HashMap<>();
    }

    public boolean addBankUser(BankUser bankUser) {
        if (database.containsKey(bankUser)) {
            return false;
        }

        int oldNumberofUsers = numberOfUsers();

        database.put(bankUser, new ArrayList<>());

        return oldNumberofUsers + 1 == numberOfUsers();
    }

    public List<BankAccount> getAccountsOf(BankUser bankUser) {
        return database.get(bankUser);
    }

    public int numberOfUsers() {
        return database.size();
    }
}
