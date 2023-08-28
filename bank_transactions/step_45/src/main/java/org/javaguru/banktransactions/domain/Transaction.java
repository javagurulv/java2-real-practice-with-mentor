package org.javaguru.banktransactions.domain;

public interface Transaction {

    int amount();

    TransactionType transactionType();

    ExpenseCategory expenseCategory();

    default boolean isDeposit() {
        return transactionType() == TransactionType.DEPOSIT;
    }

    default boolean isWithdrawal() {
        return transactionType() == TransactionType.WITHDRAWAL;
    }

}
