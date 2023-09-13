package org.javaguru.applewarehouse;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RedAppleSearchCriteriaTest {

    private RedAppleSearchCriteria criteria = new RedAppleSearchCriteria();

    @Test
    public void shouldSucceed() {
        Apple apple = new Apple("red", 200);
        assertTrue(criteria.test(apple));
    }

    @Test
    public void shouldFail() {
        Apple apple = new Apple("green", 200);
        assertFalse(criteria.test(apple));
    }

}