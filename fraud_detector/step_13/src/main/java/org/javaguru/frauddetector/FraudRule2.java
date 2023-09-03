package org.javaguru.frauddetector;

class FraudRule2 implements FraudRule {
    @Override
    public boolean isFraud(Transaction transaction) {
        return transaction.getAmount() > 1000000;
    }
}
