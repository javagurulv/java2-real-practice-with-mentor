package org.javaguru.banktransactions.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    @Test
    public void shouldCreateWithdrawalTransactionWithExpenseCategory() {
        Transaction transaction = new TransactionImpl(100, ExpenseCategory.OTHERS);
        assertNotNull(transaction);
        assertEquals(transaction.amount(), 100);
        assertEquals(transaction.transactionType(), TransactionType.WITHDRAWAL);
    }


    @Test
    public void shouldCreateDepositTransactionWithExpenseCategory() {
        Transaction transaction = new TransactionImpl(100);
        assertNotNull(transaction);
        assertEquals(transaction.amount(), 100);
        assertEquals(transaction.transactionType(), TransactionType.DEPOSIT);
    }

}