package org.javaguru.mentor.lesson_6.homework.level_4_junior;

class FactorialRecursion {

    public int factorial(int n) {
        if (n == 1){
            return 1;
        }
        return n * factorial(n - 1);
    }

}
