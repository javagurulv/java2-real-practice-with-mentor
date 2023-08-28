package org.javaguru.banktransactions.transactionapprover;

import org.javaguru.banktransactions.domain.BankAccount;
import org.javaguru.banktransactions.domain.Transaction;

public interface BankAccountTransactionApprover {

    boolean approve(BankAccount bankAccount, Transaction newTransaction);

}
