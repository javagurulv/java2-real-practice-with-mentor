package org.javaguru.banktransactions.expensesanalyser;

import org.javaguru.banktransactions.domain.BankAccount;
import org.javaguru.banktransactions.domain.ExpenseCategory;
import org.javaguru.banktransactions.domain.Transaction;

import java.util.List;

class EntertainmentExpensesCalculator extends ExpensesCalculator {

    public int calculateExpensesAmount(BankAccount bankAccount) {
        Transaction[] transactions = bankAccount.getTransactions();
        List<Transaction> withdrawalTransactions = filterWithdrawalTransactions(transactions);
        List<Transaction> withdrawalFoodTransactions = filterTransactionsByExpenseCategory(withdrawalTransactions, ExpenseCategory.ENTERTAINMENT);
        return sumTransactionAmount(withdrawalFoodTransactions);
    }

}
