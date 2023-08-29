package org.javaguru.banktransactions.currentbalance;

import org.javaguru.banktransactions.domain.BankAccount;

public interface CurrentBalanceCalculator {

    int calculate(BankAccount bankAccount);

}
