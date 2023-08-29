package org.javaguru.banktransactions.currentbalance;

import org.javaguru.banktransactions.domain.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurrentBalanceCalculatorStreamApiImplTest {

    private TransactionFactory factory = new TransactionFactory();
    private CurrentBalanceCalculator calculator = new CurrentBalanceCalculatorStreamApiImpl();

    @Test
    public void shouldReturnZeroForBankAccountWithoutTransactions() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 0, new Transaction[]{});
        assertEquals(0, calculator.calculate(bankAccount));
    }

    @Test
    public void shouldReturnSumDepositTransactions() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 0,
                factory.createDepositTransaction(100),
                factory.createDepositTransaction(100)
        );
        assertEquals(200, calculator.calculate(bankAccount));
    }

    @Test
    public void shouldReturnSumWithdrawalTransactions() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 0,
                factory.createWithdrawalTransaction(100, ExpenseCategory.OTHERS),
                factory.createWithdrawalTransaction(100, ExpenseCategory.OTHERS)
        );
        assertEquals(-200, calculator.calculate(bankAccount));
    }

    @Test
    public void shouldReturnSumDepositAndWithdrawalTransactions() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 0,
                factory.createWithdrawalTransaction(100, ExpenseCategory.OTHERS),
                factory.createDepositTransaction(100),
                factory.createDepositTransaction(50),
                factory.createWithdrawalTransaction(50, ExpenseCategory.OTHERS)
        );
        assertEquals(0, calculator.calculate(bankAccount));
    }

}