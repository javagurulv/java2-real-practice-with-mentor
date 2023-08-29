package org.javaguru.banktransactions.maxbalance;

import org.javaguru.banktransactions.domain.BankAccount;

public interface MaxBalanceCalculator {

    int calculate(BankAccount bankAccount);

}
