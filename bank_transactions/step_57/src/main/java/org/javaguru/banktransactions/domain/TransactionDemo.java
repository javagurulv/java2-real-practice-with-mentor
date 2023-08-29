package org.javaguru.banktransactions.domain;

class TransactionDemo {

    public static void main(String[] args) {
        TransactionFactory factory = new TransactionFactory();
        Transaction withdrawal = factory.createWithdrawalTransaction(10, ExpenseCategory.FOOD);
        Transaction depositWithoutExpenseCategory = factory.createDepositTransaction(10);
        Transaction depositWithExpenseCategory = factory.createDepositTransaction(10);



    }

}
