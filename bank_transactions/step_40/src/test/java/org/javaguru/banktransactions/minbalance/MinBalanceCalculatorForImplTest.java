package org.javaguru.banktransactions.minbalance;

import org.javaguru.banktransactions.domain.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinBalanceCalculatorForImplTest {

    private TransactionFactory factory = new TransactionFactory();
    private MinBalanceCalculator calculator = new MinBalanceCalculatorForImpl();

    @Test
    public void shouldReturnZeroForBankAccountWithoutTransactions() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 0, new Transaction[]{});
        assertEquals(0, calculator.calculate(bankAccount));
    }

    @Test
    public void shouldReturnMinForDepositTransactions() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 0,
                new Transaction[]{
                        factory.createDepositTransaction(100),
                        factory.createDepositTransaction(100)
                }
        );
        assertEquals(0, calculator.calculate(bankAccount));
    }

    @Test
    public void shouldReturnMinForWithdrawalTransactions() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 0,
                new Transaction[]{
                        factory.createWithdrawalTransaction(100, ExpenseCategory.OTHERS),
                        factory.createWithdrawalTransaction(100, ExpenseCategory.OTHERS)
                }
        );
        assertEquals(-200, calculator.calculate(bankAccount));
    }

    @Test
    public void shouldReturnMinForDepositAndWithdrawalTransactions() {
        BankAccount bankAccount = new BankAccount("Vasja Pupkin", 0,
                new Transaction[]{
                        factory.createWithdrawalTransaction(100, ExpenseCategory.OTHERS),
                        factory.createDepositTransaction(100),
                        factory.createDepositTransaction(50),
                        factory.createWithdrawalTransaction(50, ExpenseCategory.OTHERS)
                }
        );
        assertEquals(-100, calculator.calculate(bankAccount));
    }

}