package org.javaguru.banktransactions.withdrawalamount;

import org.javaguru.banktransactions.domain.BankAccount;

public interface WithdrawalAmountCalculator {

    int calculate(BankAccount bankAccount);

}
