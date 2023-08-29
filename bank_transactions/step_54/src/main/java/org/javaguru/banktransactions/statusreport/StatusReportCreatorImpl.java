package org.javaguru.banktransactions.statusreport;

import org.javaguru.banktransactions.currentbalance.CurrentBalanceCalculator;
import org.javaguru.banktransactions.depositamount.DepositAmountCalculator;
import org.javaguru.banktransactions.domain.BankAccount;
import org.javaguru.banktransactions.domain.Transaction;
import org.javaguru.banktransactions.maxbalance.MaxBalanceCalculator;
import org.javaguru.banktransactions.minbalance.MinBalanceCalculator;
import org.javaguru.banktransactions.withdrawalamount.WithdrawalAmountCalculator;

class StatusReportCreatorImpl implements StatusReportCreator {

    private CurrentBalanceCalculator currentBalanceCalculator;
    private DepositAmountCalculator depositAmountCalculator;
    private WithdrawalAmountCalculator withdrawalAmountCalculator;
    private MaxBalanceCalculator maxBalanceCalculator;
    private MinBalanceCalculator minBalanceCalculator;

    public StatusReportCreatorImpl(CurrentBalanceCalculator currentBalanceCalculator,
                                   DepositAmountCalculator depositAmountCalculator,
                                   WithdrawalAmountCalculator withdrawalAmountCalculator,
                                   MaxBalanceCalculator maxBalanceCalculator,
                                   MinBalanceCalculator minBalanceCalculator) {
        this.currentBalanceCalculator = currentBalanceCalculator;
        this.depositAmountCalculator = depositAmountCalculator;
        this.withdrawalAmountCalculator = withdrawalAmountCalculator;
        this.maxBalanceCalculator = maxBalanceCalculator;
        this.minBalanceCalculator = minBalanceCalculator;
    }

    @Override
    public String create(BankAccount bankAccount) {
        StringBuilder reportBuilder = new StringBuilder();
        createTransactionListSection(bankAccount, reportBuilder);
        createSummarySection(bankAccount, reportBuilder);
        return reportBuilder.toString();
    }

    private void createTransactionListSection(BankAccount bankAccount,
                                              StringBuilder reportBuilder) {
        reportBuilder.append("Transaction list:");
        reportBuilder.append(System.lineSeparator());

        for (Transaction transaction : bankAccount.getTransactions()) {
            reportBuilder.append(transaction.transactionType().name());
            reportBuilder.append(" ");
            reportBuilder.append(transaction.amount());
            reportBuilder.append(System.lineSeparator());
        }

        reportBuilder.append(System.lineSeparator());
    }

    private void createSummarySection(BankAccount bankAccount,
                                      StringBuilder reportBuilder) {
        reportBuilder.append("Summary:");
        reportBuilder.append("Starting balance: 0");

        int currentBalance = currentBalanceCalculator.calculate(bankAccount);
        reportBuilder.append("Current Balance: " + currentBalance);

        int depositAmount = depositAmountCalculator.calculate(bankAccount);
        reportBuilder.append("Deposit sum: " + depositAmount);
        reportBuilder.append(System.lineSeparator());

        int withdrawalAmount = withdrawalAmountCalculator.calculate(bankAccount);
        reportBuilder.append("Withdrawal sum: " + withdrawalAmount);
        reportBuilder.append(System.lineSeparator());

        int maxBalance = maxBalanceCalculator.calculate(bankAccount);
        reportBuilder.append("Max balance: " + maxBalance);
        reportBuilder.append(System.lineSeparator());

        int minBalance = minBalanceCalculator.calculate(bankAccount);
        reportBuilder.append("Min balance: " + minBalance);
        reportBuilder.append(System.lineSeparator());
    }

}
