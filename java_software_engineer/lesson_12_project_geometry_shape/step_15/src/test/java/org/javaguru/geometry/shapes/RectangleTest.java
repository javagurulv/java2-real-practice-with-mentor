package org.javaguru.geometry.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    public void shouldCalculateArea() {
        Rectangle rectangle = new Rectangle("A", 1.0, 2.0);
        assertEquals(rectangle.calculateArea(), 2.0, 0.01);
    }

    @Test
    public void shouldCalculatePerimeter() {
        Rectangle rectangle = new Rectangle("A", 1.0, 2.0);
        assertEquals(rectangle.calculatePerimeter(), 6.0, 0.01);
    }

}