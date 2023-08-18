package org.javaguru.banktransactions;

class Transaction {

    private final int amount;
    private final TransactionType transactionType;

    public Transaction(int amount,
                       TransactionType transactionType) {
        this.amount = amount;
        this.transactionType = transactionType;
    }

    public int getAmount() {
        return amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }
}
