package org.javaguru.banktransactions;

import org.immutables.value.Value;

@Value.Immutable
interface Transaction {

    @Value.Parameter
    String ownerFullName();

    @Value.Parameter
    int amount();

    @Value.Parameter
    TransactionType transactionType();

}
