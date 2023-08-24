package org.javaguru.banktransactions.currentbalance;

import org.javaguru.banktransactions.currentbalance.CurrentBalanceCalculator;
import org.javaguru.banktransactions.currentbalance.CurrentBalanceCalculatorForImpl;
import org.javaguru.banktransactions.domain.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurrentBalanceCalculatorForImplTest {

    private CurrentBalanceCalculator calculator = new CurrentBalanceCalculatorForImpl();

    @Test
    public void shouldReturnZeroForBankAccountWithoutTransactions() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 0, new Transaction[]{});
        assertEquals(0, calculator.calculate(bankAccount));
    }

    @Test
    public void shouldReturnSumDepositTransactions() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 0,
                new Transaction[]{
                        ImmutableTransaction.of(100, TransactionType.DEPOSIT, ExpenseCategory.OTHERS),
                        ImmutableTransaction.of(100, TransactionType.DEPOSIT, ExpenseCategory.OTHERS)
                }
        );
        assertEquals(200, calculator.calculate(bankAccount));
    }

    @Test
    public void shouldReturnSumWithdrawalTransactions() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 0,
                new Transaction[]{
                        ImmutableTransaction.of(100, TransactionType.WITHDRAWAL, ExpenseCategory.OTHERS),
                        ImmutableTransaction.of(100, TransactionType.WITHDRAWAL, ExpenseCategory.OTHERS)
                }
        );
        assertEquals(-200, calculator.calculate(bankAccount));
    }

    @Test
    public void shouldReturnSumDepositAndWithdrawalTransactions() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 0,
                new Transaction[]{
                        ImmutableTransaction.of(100, TransactionType.WITHDRAWAL, ExpenseCategory.OTHERS),
                        ImmutableTransaction.of(100, TransactionType.DEPOSIT, ExpenseCategory.OTHERS),
                        ImmutableTransaction.of(50, TransactionType.DEPOSIT, ExpenseCategory.OTHERS),
                        ImmutableTransaction.of(50, TransactionType.WITHDRAWAL, ExpenseCategory.OTHERS)
                }
        );
        assertEquals(0, calculator.calculate(bankAccount));
    }

}