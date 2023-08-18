package org.javaguru.banktransactions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    @Test
    public void shouldCreateBook() {
        Transaction transaction = ImmutableTransaction.of(
                "Vasja Pupkin",
                100,
                TransactionType.DEPOSIT);
        assertNotNull(transaction);
        assertEquals(transaction.ownerFullName(), "Vasja Pupkin");
        assertEquals(transaction.amount(), 100);
        assertEquals(transaction.transactionType(), TransactionType.DEPOSIT);
    }

    @Test
    public void shouldBuildTransactionWithBuilder() {
        Transaction transaction = ImmutableTransaction.builder()
                .ownerFullName("Vasja Pupkin")
                .amount(100)
                .transactionType(TransactionType.DEPOSIT)
                .build();
        assertNotNull(transaction);
        assertEquals(transaction.ownerFullName(), "Vasja Pupkin");
        assertEquals(transaction.amount(), 100);
        assertEquals(transaction.transactionType(), TransactionType.DEPOSIT);
    }

}