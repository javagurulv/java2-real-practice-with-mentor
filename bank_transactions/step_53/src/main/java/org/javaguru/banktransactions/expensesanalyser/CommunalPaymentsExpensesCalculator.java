package org.javaguru.banktransactions.expensesanalyser;

import org.javaguru.banktransactions.domain.ExpenseCategory;

class CommunalPaymentsExpensesCalculator extends ExpensesCalculator {
    @Override
    protected ExpenseCategory getExpenseCategory() {
        return ExpenseCategory.COMMUNAL_PAYMENTS;
    }
}
