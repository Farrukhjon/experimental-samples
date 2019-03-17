package org.farrukh.experiments.money.model;

import java.util.Date;

public class Transaction {

    private int id;

    private Date date;

    private Account fromAccount;

    private Account toAccount;

    private double amount;

    private String description;

    public Transaction(Account fromAccount, Account toAccount, double amount) {
        this(new Date(), fromAccount, toAccount, amount);
    }

    public Transaction(Date date, Account fromAccount, Account toAccount, double amount, String description) {
        this.date = date;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.description = description;
    }

    public Transaction(Date date, Account from, Account to, double amount) {
        this(date, from, to, amount, null);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Account getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(Account fromAccount) {
        this.fromAccount = fromAccount;
    }

    public Account getToAccount() {
        return toAccount;
    }

    public void setToAccount(Account toAccount) {
        this.toAccount = toAccount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
