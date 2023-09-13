package org.javaguru.mentor.lesson_20.lessoncode;

public class NewThreadExample {

    public static void main(String[] args) {
        Thread newThread = new Thread(() -> {
            int sum = 0;
            for (int i = 1; i <= 100; i++) {
                sum += i;
            }
            System.out.println("SUM 1 .. 100 = " + sum);
        });

        newThread.start();
    }

}
