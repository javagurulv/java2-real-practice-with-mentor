package org.javaguru.banktransactions;

class Transaction {

    private final String ownerFullName;
    private final int amount;
    private final TransactionType transactionType;

    public Transaction(String ownerFullName,
                       int amount,
                       TransactionType transactionType) {
        this.ownerFullName = ownerFullName;
        this.amount = amount;
        this.transactionType = transactionType;
    }

    public String getOwnerFullName() {
        return ownerFullName;
    }

    public int getAmount() {
        return amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }
}
