package org.javaguru.banktransactions.expensesanalyser;

import org.javaguru.banktransactions.domain.ExpenseCategory;

class FoodExpensesCalculator extends ExpensesCalculator {
    @Override
    protected ExpenseCategory getExpenseCategory() {
        return ExpenseCategory.FOOD;
    }
}
