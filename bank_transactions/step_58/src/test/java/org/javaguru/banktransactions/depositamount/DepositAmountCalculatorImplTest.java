package org.javaguru.banktransactions.depositamount;

import org.javaguru.banktransactions.domain.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepositAmountCalculatorImplTest {

    private TransactionFactory factory = new TransactionFactory();
    private DepositAmountCalculator calculator = new DepositAmountCalculatorImpl();

    @Test
    public void shouldReturnZeroForBankAccountWithoutTransactions() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 0, new Transaction[]{});
        assertEquals(0, calculator.calculate(bankAccount));
    }

    @Test
    public void shouldReturnDepositSum() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 0,
                factory.createDepositTransaction(100),
                factory.createDepositTransaction(100)
        );
        assertEquals(200, calculator.calculate(bankAccount));
    }

    @Test
    public void shouldIgnoreWithdrawals() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 0,
                factory.createWithdrawalTransaction(100, ExpenseCategory.OTHERS),
                factory.createDepositTransaction(100)
        );
        assertEquals(100, calculator.calculate(bankAccount));
    }

}