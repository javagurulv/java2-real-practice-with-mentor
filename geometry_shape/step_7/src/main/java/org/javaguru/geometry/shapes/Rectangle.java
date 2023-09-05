package org.javaguru.geometry.shapes;

class Rectangle extends Shape {

    private int a;
    private int b;

    public Rectangle(String title, int a, int b) {
        super(title);
        this.a = a;
        this.b = b;
    }
    @Override
    public double calculatePerimeter() {
        return (a + b) * 2;
    }

    @Override
    public double calculateArea() {
        return a * b;
    }
}
