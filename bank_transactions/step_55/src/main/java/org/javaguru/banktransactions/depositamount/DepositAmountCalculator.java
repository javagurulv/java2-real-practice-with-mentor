package org.javaguru.banktransactions.depositamount;

import org.javaguru.banktransactions.domain.BankAccount;

public interface DepositAmountCalculator {

    int calculate(BankAccount bankAccount);

}
