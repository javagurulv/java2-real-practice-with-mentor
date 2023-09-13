package org.javaguru.transactionanalysis;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransactionAnalysisServiceTest {

    private TransactionAnalysisService service = new TransactionAnalysisService();

    @Test
    public void shouldFindAllTransactionsMadeIn2011() {
        List<Transaction> transactions = service.findAllTransactionsMadeIn2011(
                TransactionTestData.getTransactions()
        );
        assertEquals(transactions.size(), 2);
    }

}