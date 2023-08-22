package org.javaguru.banktransactions;

class TransactionDemo {

    public static void main(String[] args) {
        Transaction withdrawal = ImmutableTransaction.of(10, TransactionType.WITHDRAWAL, ExpenseCategory.FOOD);
        Transaction depositWithoutExpenseCategory = ImmutableTransaction.of(10, TransactionType.DEPOSIT, null);
        Transaction depositWithExpenseCategory = ImmutableTransaction.of(10, TransactionType.DEPOSIT, ExpenseCategory.FOOD);



    }

}
