package org.javaguru.mentor.lesson_3.lessoncode;

public class Questionnaire {

    String name;
    Question questionOne;
    Question questionTwo;

    public Questionnaire(String name, Question questionOne, Question questionTwo) {
        this.name = name;
        this.questionOne = questionOne;
        this.questionTwo = questionTwo;
    }

}
