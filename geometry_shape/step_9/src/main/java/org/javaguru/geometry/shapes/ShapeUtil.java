package org.javaguru.geometry.shapes;

import java.util.Random;

class ShapeUtil {

    private Random random = new Random();

    public Circle createRandomCircle() {
        double radius = random.nextDouble(10);
        return new Circle("Circle", radius);
    }

    public Square createRandomSquare() {
        double side = random.nextDouble(10);
        return new Square("Square", side);
    }

}
