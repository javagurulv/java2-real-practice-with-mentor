package org.javaguru.banktransactions.domain;

public class BankAccount {

    private String ownerFullName;

    private int creditLimit;
    private Transaction[] transactions;

    public BankAccount(String ownerFullName,
                       int creditLimit,
                       Transaction ... transactions) {
        this.ownerFullName = ownerFullName;
        this.creditLimit = creditLimit;
        this.transactions = transactions;
    }

    public String getOwnerFullName() {
        return ownerFullName;
    }

    public int getCreditLimit() {
        return creditLimit;
    }

    public Transaction[] getTransactions() {
        return transactions;
    }

}
