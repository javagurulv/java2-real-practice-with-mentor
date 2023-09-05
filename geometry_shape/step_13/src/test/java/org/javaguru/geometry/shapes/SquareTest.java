package org.javaguru.geometry.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

    @Test
    public void shouldCalculateArea() {
        Square square = new Square("A", 1);
        assertEquals(square.calculateArea(), 1.0, 0.01);
    }

    @Test
    public void shouldCalculatePerimeter() {
        Square square = new Square("A", 1);
        assertEquals(square.calculatePerimeter(), 4.0, 0.01);
    }

}