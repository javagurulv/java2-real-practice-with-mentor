package org.javaguru.banktransactions;

import java.util.Arrays;

class DepositAmountCalculatorImpl implements DepositAmountCalculator {
    @Override
    public int calculate(BankAccount bankAccount) {
        return Arrays.stream(bankAccount.getTransactions())
                .filter(Transaction::isDeposit)
                .map(Transaction::amount)
                .reduce(0, Integer::sum);
    }
}
