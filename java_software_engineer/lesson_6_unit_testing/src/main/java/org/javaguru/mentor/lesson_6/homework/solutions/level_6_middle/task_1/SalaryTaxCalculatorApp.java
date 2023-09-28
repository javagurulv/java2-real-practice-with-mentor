package org.javaguru.mentor.lesson_6.homework.solutions.level_6_middle.task_1;

import java.util.Scanner;

public class SalaryTaxCalculatorApp {

    public static void main(String[] args) {
        System.out.println("Enter salary: ");
        Scanner sc = new Scanner(System.in);
        double salary = sc.nextDouble();

        SalaryTaxCalculator calculator = new SalaryTaxCalculator();
        double tax = calculator.calculate(salary);

        System.out.println("Tax = " + tax);
    }

}
