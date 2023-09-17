package org.javaguru.mentor.lesson_3.homework.solutions.level_7_senior.task_1;

class Circle {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }

}
