package org.javaguru.mentor.lesson_3;

import java.util.Scanner;

public class QuestionnaireApp {

    public static void main(String[] args) {
        Question questionAboutYourself = new Question("All good?");
        Question questionAboutJavaGuru = new Question("All fine?");
        Questionnaire questionnaire = new Questionnaire("Alex", questionAboutYourself, questionAboutJavaGuru);

        questionnaire.questionOne.answer = true;
        System.out.println(questionnaire.questionOne.questionText);
        System.out.println(questionnaire.questionOne.answer);

        questionnaire.questionTwo.answer = true;
        System.out.println(questionnaire.questionTwo.questionText);
        System.out.println(questionnaire.questionTwo.answer);

        Scanner scanner = new Scanner(System.in);
        boolean nextBoolean = scanner.nextBoolean();
        System.out.println(nextBoolean);
    }
}
