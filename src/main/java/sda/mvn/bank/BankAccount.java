package sda.mvn.bank;

import java.util.Objects;

public class BankAccount {

    private String id;
    private String type;
    private int amount;

    public BankAccount(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return amount == that.amount &&
                Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, amount);
    }

    public static BankAccount instanceOf(String type, int amount) {
        BankAccount bankAccount = new BankAccount(type);
        bankAccount.amount = amount;
        return bankAccount;
    }
}
