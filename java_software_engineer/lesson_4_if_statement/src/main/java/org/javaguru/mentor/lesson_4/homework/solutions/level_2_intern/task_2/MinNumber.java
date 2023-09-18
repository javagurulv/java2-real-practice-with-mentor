package org.javaguru.mentor.lesson_4.homework.solutions.level_2_intern.task_2;

import java.util.Scanner;

class MinNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter first number: ");
        int number1 = scanner.nextInt();
        System.out.println("Please enter second number: ");
        int number2 = scanner.nextInt();

        if (number1 < number2) {
            System.out.println(number1);
        } else {
            System.out.println(number2);
        }
    }

}
