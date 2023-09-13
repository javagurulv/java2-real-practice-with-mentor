package org.javaguru.applewarehouse;

import org.javaguru.applewarehouse.Apple;
import org.javaguru.applewarehouse.AppleWarehouse;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppleWarehouseTest {

    @Test
    public void shouldFindGreenApples() {
        AppleWarehouse warehouse = new AppleWarehouse();
        List<Apple> greenApples = warehouse.findGreenApples();
        assertEquals(greenApples.size(), 3);
    }

}