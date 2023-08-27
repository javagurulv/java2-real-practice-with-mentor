package org.javaguru.banktransactions.statusreport;

import org.javaguru.banktransactions.domain.BankAccount;

public interface StatusReportCreator {

    String create(BankAccount bankAccount);

}
