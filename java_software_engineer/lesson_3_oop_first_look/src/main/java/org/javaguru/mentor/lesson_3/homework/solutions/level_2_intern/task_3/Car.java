package org.javaguru.mentor.lesson_3.homework.solutions.level_2_intern.task_3;

class Car {

    private String manufacturer;
    private String color;
    private int price;

    public Car(String manufacturer,
               String color,
               int price) {
        this.manufacturer = manufacturer;
        this.color = color;
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }
}
