package org.javaguru.mentor.lesson_5;

class OddNumberDetectorApp {

    public static void main(String[] args) {
        int number = 4525433;
        boolean isOdd = (number % 2) != 0;
        System.out.println("Number is odd = " + isOdd);

        OddNumberDetector oddNumberDetector = new OddNumberDetector();
        System.out.println("Number is odd = " + oddNumberDetector.isOdd(12));
        System.out.println("Number is odd = " + oddNumberDetector.isOdd(13));
        System.out.println("Number is odd = " + oddNumberDetector.isOdd(15));
    }

}
