package org.javaguru.transactionanalysis;

import java.util.List;
import java.util.stream.Collectors;

class TransactionAnalysisService {

    public List<Transaction> findAllTransactionsMadeIn2011(List<Transaction> transactions) {
        return transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .collect(Collectors.toList());
    }

}
