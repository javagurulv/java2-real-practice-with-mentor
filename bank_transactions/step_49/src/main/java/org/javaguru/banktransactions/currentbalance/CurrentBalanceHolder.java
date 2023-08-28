package org.javaguru.banktransactions.currentbalance;

import org.javaguru.banktransactions.domain.Transaction;

public class CurrentBalanceHolder {
    private int currentBalance = 0;

    public int applyTransaction(Transaction transaction) {
        if (transaction.isDeposit()) {
            currentBalance = currentBalance + transaction.amount();
        }
        if (transaction.isWithdrawal()) {
            currentBalance = currentBalance - transaction.amount();
        }
        return currentBalance;
    }

}
