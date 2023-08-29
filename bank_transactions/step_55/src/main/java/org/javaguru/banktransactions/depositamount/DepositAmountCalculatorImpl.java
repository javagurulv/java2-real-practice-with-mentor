package org.javaguru.banktransactions.depositamount;

import org.javaguru.banktransactions.domain.BankAccount;
import org.javaguru.banktransactions.domain.Transaction;

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
