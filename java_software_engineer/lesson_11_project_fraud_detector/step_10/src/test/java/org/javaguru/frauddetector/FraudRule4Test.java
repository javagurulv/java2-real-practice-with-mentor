package org.javaguru.frauddetector;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FraudRule4Test {

    private FraudRule4 fraudRule = new FraudRule4();

    @Test
    public void shouldBeFraud() {
        Trader trader = new Trader("Zorro", "Kingston", "Jamaica");
        Transaction transaction = new Transaction(trader, 100);
        assertTrue(fraudRule.isFraud(transaction));
    }

    @Test
    public void shouldNotBeFraud() {
        Trader trader = new Trader("Zorro", "Kingston", "Italy");
        Transaction transaction = new Transaction(trader, 100);
        assertFalse(fraudRule.isFraud(transaction));
    }

}