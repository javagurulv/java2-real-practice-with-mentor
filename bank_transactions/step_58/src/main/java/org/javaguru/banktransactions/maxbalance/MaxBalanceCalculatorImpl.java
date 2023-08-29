package org.javaguru.banktransactions.maxbalance;

import org.javaguru.banktransactions.currentbalance.CurrentBalanceHolder;
import org.javaguru.banktransactions.domain.BankAccount;
import org.javaguru.banktransactions.domain.Transaction;

class MaxBalanceCalculatorImpl implements MaxBalanceCalculator {
    @Override
    public int calculate(BankAccount bankAccount) {
        int maxBalance = 0;
        CurrentBalanceHolder currentBalanceHolder = new CurrentBalanceHolder();
        for (Transaction transaction : bankAccount.getTransactions()) {
            int currentBalance = currentBalanceHolder.applyTransaction(transaction);
            if (currentBalance > maxBalance) {
                maxBalance = currentBalance;
            }
        }
        return maxBalance;
    }

}
