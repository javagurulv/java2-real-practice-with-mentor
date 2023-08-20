package org.javaguru.banktransactions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WithdrawalAmountCalculatorImplTest {

    private WithdrawalAmountCalculator calculator = new WithdrawalAmountCalculatorImpl();

    @Test
    public void shouldReturnZeroForBankAccountWithoutTransactions() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 0, new Transaction[]{});
        assertEquals(0, calculator.calculate(bankAccount));
    }

    @Test
    public void shouldReturnWithdrawalSum() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 0,
                new Transaction[]{
                        ImmutableTransaction.of(100, TransactionType.WITHDRAWAL),
                        ImmutableTransaction.of(100, TransactionType.WITHDRAWAL)
                }
        );
        assertEquals(200, calculator.calculate(bankAccount));
    }

    @Test
    public void shouldIgnoreDeposits() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 0,
                new Transaction[]{
                        ImmutableTransaction.of(100, TransactionType.WITHDRAWAL),
                        ImmutableTransaction.of(100, TransactionType.DEPOSIT)
                }
        );
        assertEquals(100, calculator.calculate(bankAccount));
    }

}