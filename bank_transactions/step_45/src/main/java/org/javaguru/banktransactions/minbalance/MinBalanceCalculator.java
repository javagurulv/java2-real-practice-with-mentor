package org.javaguru.banktransactions.minbalance;

import org.javaguru.banktransactions.domain.BankAccount;

public interface MinBalanceCalculator {

    int calculate(BankAccount bankAccount);

}
