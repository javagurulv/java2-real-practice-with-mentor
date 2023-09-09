package org.javaguru.mentor.lesson_4.lessoncode;

import java.util.Scanner;

public class IsPositiveIfExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number: ");
        int number = scanner.nextInt();

        // Variant 1
        boolean isPositive = number > 0;
        if (isPositive) {
            System.out.println("Number is positive!");
        }

        // Variant 2
        if (number > 0) {
            System.out.println("Number is positive!");
        }

    }

}
