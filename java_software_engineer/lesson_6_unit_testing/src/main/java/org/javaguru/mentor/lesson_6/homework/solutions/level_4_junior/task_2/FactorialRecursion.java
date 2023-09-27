package org.javaguru.mentor.lesson_6.homework.solutions.level_4_junior.task_2;

class FactorialRecursion {

    public int factorial(int n) {
        if (n == 0 || n == 1){
            return 1;
        }
        return n * factorial(n - 1);
    }

}
