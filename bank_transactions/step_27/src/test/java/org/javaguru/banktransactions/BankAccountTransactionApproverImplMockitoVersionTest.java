package org.javaguru.banktransactions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BankAccountTransactionApproverImplMockitoVersionTest {

    @Mock
    private CurrentBalanceCalculator currentBalanceCalculator;
    @InjectMocks
    private BankAccountTransactionApproverImpl approver;

    @Test
    public void shouldNotAllowWithdrawalWhenBalanceIsZero() {
        BankAccount bankAccount = mock(BankAccount.class);
        Transaction newTransaction = ImmutableTransaction.of(100, TransactionType.WITHDRAWAL);
        when(currentBalanceCalculator.calculate(bankAccount)).thenReturn(0);
        assertFalse(approver.approve(bankAccount, newTransaction));
    }

    @Test
    public void shouldAllowDepositWhenBalanceIsZero() {
        BankAccount bankAccount = mock(BankAccount.class);;
        Transaction newTransaction = ImmutableTransaction.of(100, TransactionType.DEPOSIT);
        when(currentBalanceCalculator.calculate(bankAccount)).thenReturn(0);
        assertTrue(approver.approve(bankAccount, newTransaction));
    }

    @Test
    public void shouldNotAllowWithdrawalWhenBalanceGoesBelowZero() {
        BankAccount bankAccount = mock(BankAccount.class);
        Transaction newTransaction = ImmutableTransaction.of(200, TransactionType.WITHDRAWAL);
        when(currentBalanceCalculator.calculate(bankAccount)).thenReturn(100);
        assertFalse(approver.approve(bankAccount, newTransaction));
    }

    @Test
    public void shouldAllowWithdrawalWhenBalanceNotGoesBelowZero() {
        BankAccount bankAccount = mock(BankAccount.class);
        Transaction newTransaction = ImmutableTransaction.of(50, TransactionType.WITHDRAWAL);
        when(currentBalanceCalculator.calculate(bankAccount)).thenReturn(100);
        assertTrue(approver.approve(bankAccount, newTransaction));
    }

    @Test
    public void shouldAllowDepositWhenBalanceAboveZero() {
        BankAccount bankAccount = mock(BankAccount.class);
        Transaction newTransaction = ImmutableTransaction.of(100, TransactionType.DEPOSIT);
        when(currentBalanceCalculator.calculate(bankAccount)).thenReturn(50);
        assertTrue(approver.approve(bankAccount, newTransaction));
    }

}