package org.javaguru.banktransactions;

import java.util.Arrays;

class WithdrawalAmountCalculatorImpl implements WithdrawalAmountCalculator {
    @Override
    public int calculate(BankAccount bankAccount) {
        return Arrays.stream(bankAccount.getTransactions())
                .filter(Transaction::isWithdrawal)
                .map(Transaction::amount)
                .reduce(0, Integer::sum);
    }
}
