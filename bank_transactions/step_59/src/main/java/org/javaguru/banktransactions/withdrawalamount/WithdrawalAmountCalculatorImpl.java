package org.javaguru.banktransactions.withdrawalamount;

import org.javaguru.banktransactions.domain.BankAccount;
import org.javaguru.banktransactions.domain.Transaction;

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
