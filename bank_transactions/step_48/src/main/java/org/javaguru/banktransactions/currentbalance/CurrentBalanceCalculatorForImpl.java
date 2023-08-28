package org.javaguru.banktransactions.currentbalance;

import org.javaguru.banktransactions.domain.BankAccount;
import org.javaguru.banktransactions.domain.Transaction;

class CurrentBalanceCalculatorForImpl implements CurrentBalanceCalculator {

    @Override
    public int calculate(BankAccount bankAccount) {
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
        }
        return currentBalance;
    }

}
