package org.javaguru.frauddetector;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FraudRule5Test {

    private FraudRule5 fraudRule
            = new FraudRule5();

    @Test
    public void shouldBeFraud() {
        Trader trader = new Trader("Zorro", "Berlin", "Germany");
        Transaction transaction = new Transaction(trader, 1001);
        assertTrue(fraudRule.isFraud(transaction));
    }

    @Test
    public void shouldNotBeFraud_1000() {
        Trader trader = new Trader("Zorro", "Berlin", "Germany");
        Transaction transaction = new Transaction(trader, 1000);
        assertFalse(fraudRule.isFraud(transaction));
    }

    @Test
    public void shouldNotBeFraud_LessThan_1000() {
        Trader trader = new Trader("Zorro", "Berlin", "Germany");
        Transaction transaction = new Transaction(trader, 10);
        assertFalse(fraudRule.isFraud(transaction));
    }

    @Test
    public void shouldNotBeFraud_OtherCountry() {
        Trader trader = new Trader("Zorro", "Berlin", "Italy");
        Transaction transaction = new Transaction(trader, 1001);
        assertFalse(fraudRule.isFraud(transaction));
    }

}