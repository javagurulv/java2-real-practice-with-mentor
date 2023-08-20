package org.javaguru.banktransactions;

class CurrentBalanceCalculatorForImpl implements CurrentBalanceCalculator {

    @Override
    public int calculate(BankAccount bankAccount) {
        int currentBalance = 0;
        Transaction[] transactions = bankAccount.getTransactions();
        for (int i = 0; i < transactions.length; i++) {
            Transaction transaction = transactions[i];
            if (transaction.transactionType() == TransactionType.DEPOSIT) {
                currentBalance = currentBalance + transaction.amount();
            }
            if (transaction.transactionType() == TransactionType.WITHDRAWAL) {
                currentBalance = currentBalance - transaction.amount();
            }
        }
        return currentBalance;
    }

}
