package org.javaguru.banktransactions.expensesanalyser;

import org.javaguru.banktransactions.domain.ExpenseCategory;

class OthersExpensesCalculator extends ExpensesCalculator {
    @Override
    protected ExpenseCategory getExpenseCategory() {
        return ExpenseCategory.OTHERS;
    }
}

