package org.javaguru.banktransactions.minbalance;

import org.javaguru.banktransactions.domain.BankAccount;
import org.javaguru.banktransactions.domain.Transaction;

class MinBalanceCalculatorForImpl implements MinBalanceCalculator {
    @Override
    public int calculate(BankAccount bankAccount) {
        int minBalance = 0;
        int currentBalance = 0;
        Transaction[] transactions = bankAccount.getTransactions();
        for (int i = 0; i < transactions.length; i++) {
            Transaction transaction = transactions[i];
            if (transaction.isDeposit()) {
                currentBalance = currentBalance + transaction.amount();
            }
            if (transaction.isWithdrawal()) {
                currentBalance = currentBalance - transaction.amount();
            }
            if (currentBalance < minBalance) {
                minBalance = currentBalance;
            }
        }
        return minBalance;
    }
}
