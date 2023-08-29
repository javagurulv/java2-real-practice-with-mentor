package org.javaguru.banktransactions.expensesanalyser;

import org.javaguru.banktransactions.domain.ExpenseCategory;

class LoansExpensesCalculator extends ExpensesCalculator {
    @Override
    protected ExpenseCategory getExpenseCategory() {
        return ExpenseCategory.LOANS;
    }
}
