package org.javaguru.banktransactions.domain;

import org.javaguru.banktransactions.domain.ExpenseCategory;
import org.javaguru.banktransactions.domain.ImmutableTransaction;
import org.javaguru.banktransactions.domain.Transaction;
import org.javaguru.banktransactions.domain.TransactionType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    @Test
    public void shouldCreateWithdrawalTransactionWithExpenseCategory() {
        Transaction transaction = ImmutableTransaction.of(
                100,
                TransactionType.WITHDRAWAL,
                ExpenseCategory.OTHERS);
        assertNotNull(transaction);
        assertEquals(transaction.amount(), 100);
        assertEquals(transaction.transactionType(), TransactionType.WITHDRAWAL);
    }


    @Test
    public void shouldCreateDepositTransactionWithExpenseCategory() {
        Transaction transaction = ImmutableTransaction.of(
                100,
                TransactionType.DEPOSIT,
                ExpenseCategory.OTHERS);
        assertNotNull(transaction);
        assertEquals(transaction.amount(), 100);
        assertEquals(transaction.transactionType(), TransactionType.DEPOSIT);
    }

    @Test
    public void shouldThrowExceptionWhenCreateDepositTransactionWithoutExpenseCategory() {
        assertThrows(NullPointerException.class, () ->
            ImmutableTransaction.of(
                    100,
                    TransactionType.DEPOSIT,
                    null)
        );
    }

    @Test
    public void shouldBuildTransactionWithBuilder() {
        Transaction transaction = ImmutableTransaction.builder()
                .amount(100)
                .transactionType(TransactionType.DEPOSIT)
                .expenseCategory(ExpenseCategory.OTHERS)
                .build();
        assertNotNull(transaction);
        assertEquals(transaction.amount(), 100);
        assertEquals(transaction.transactionType(), TransactionType.DEPOSIT);
    }

}