package org.javaguru.applewarehouse;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeavyAppleSearchCriteriaTest {

    private HeavyAppleSearchCriteria criteria = new HeavyAppleSearchCriteria();

    @Test
    public void shouldSucceed() {
        Apple apple = new Apple("red", 200);
        assertTrue(criteria.test(apple));
    }

    @Test
    public void shouldFail() {
        Apple apple = new Apple("red", 100);
        assertFalse(criteria.test(apple));
    }

}