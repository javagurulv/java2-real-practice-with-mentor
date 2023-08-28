package org.javaguru.banktransactions.transactionapprover;

import org.javaguru.banktransactions.currentbalance.CurrentBalanceCalculator;
import org.javaguru.banktransactions.domain.BankAccount;
import org.javaguru.banktransactions.domain.Transaction;

class BankAccountTransactionApproverImpl implements BankAccountTransactionApprover {

    private CurrentBalanceCalculator currentBalanceCalculator;

    public BankAccountTransactionApproverImpl(CurrentBalanceCalculator currentBalanceCalculator) {
        this.currentBalanceCalculator = currentBalanceCalculator;
    }

    @Override
    public boolean approve(BankAccount bankAccount,
                           Transaction newTransaction) {
        int currentBalance = currentBalanceCalculator.calculate(bankAccount);
        int totalAmountAllowedToWithdraw = currentBalance + bankAccount.getCreditLimit();
        return newTransaction.isDeposit()
                || (newTransaction.isWithdrawal()
                        && totalAmountAllowedToWithdraw >= newTransaction.amount());
    }

}
