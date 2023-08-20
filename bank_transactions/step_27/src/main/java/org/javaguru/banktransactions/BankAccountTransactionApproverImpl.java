package org.javaguru.banktransactions;

class BankAccountTransactionApproverImpl implements BankAccountTransactionApprover {

    private CurrentBalanceCalculator currentBalanceCalculator;

    public BankAccountTransactionApproverImpl(CurrentBalanceCalculator currentBalanceCalculator) {
        this.currentBalanceCalculator = currentBalanceCalculator;
    }

    @Override
    public boolean approve(BankAccount bankAccount,
                           Transaction newTransaction) {
        int currentBalance = currentBalanceCalculator.calculate(bankAccount);
        return newTransaction.isDeposit()
                || (newTransaction.isWithdrawal() && currentBalance >= newTransaction.amount());
    }

}
