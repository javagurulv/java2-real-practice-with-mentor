package org.javaguru.banktransactions.depositamount;

import org.javaguru.banktransactions.depositamount.DepositAmountCalculator;
import org.javaguru.banktransactions.depositamount.DepositAmountCalculatorImpl;
import org.javaguru.banktransactions.domain.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepositAmountCalculatorImplTest {

    private DepositAmountCalculator calculator = new DepositAmountCalculatorImpl();

    @Test
    public void shouldReturnZeroForBankAccountWithoutTransactions() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 0, new Transaction[]{});
        assertEquals(0, calculator.calculate(bankAccount));
    }

    @Test
    public void shouldReturnDepositSum() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 0,
                new Transaction[]{
                        ImmutableTransaction.of(100, TransactionType.DEPOSIT, ExpenseCategory.OTHERS),
                        ImmutableTransaction.of(100, TransactionType.DEPOSIT, ExpenseCategory.OTHERS)
                }
        );
        assertEquals(200, calculator.calculate(bankAccount));
    }

    @Test
    public void shouldIgnoreWithdrawals() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 0,
                new Transaction[]{
                        ImmutableTransaction.of(100, TransactionType.WITHDRAWAL, ExpenseCategory.OTHERS),
                        ImmutableTransaction.of(100, TransactionType.DEPOSIT, ExpenseCategory.OTHERS)
                }
        );
        assertEquals(100, calculator.calculate(bankAccount));
    }

}