package quizapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import quizapp.model.Question;
import quizapp.model.QuestionType;
import quizapp.service.Quiz;
import quizapp.util.InputParser;

public class Main {
    public static void main(String[] args) {
        Question question1 = new Question(QuestionType.SINGLE_CHOICE, "Treść pytania nr 1", List.of("A: Poprawna", "B: Błędna", "C: Błędna"), List.of(0));

        Question question2 = new Question(QuestionType.SINGLE_CHOICE, "Treść pytania nr 2", List.of("A: Błędna", "B: Poprawna", "C: Poprawna"), List.of(1, 2));

        List<Question> questions = List.of(question1, question2);
        Quiz quizTest = new Quiz(questions);

        Scanner scanner = new Scanner(System.in);

        while(quizTest.hasNextQuestion()){
            System.out.println("=============================");
            System.out.println("||   " + quizTest.getCurrentQuestion().getQuestionText() + "    ||");

            for(String option : quizTest.getCurrentQuestion().getAnswerOptions()) {
                System.out.println("|| "+ option + "              ||");
            }
            System.out.println("||-------------------------||");
            System.out.println("|| Podaj odpowiedź:        ||");
            System.out.print("|| ");
            String userAnswer = scanner.nextLine();
            List<Integer> answerIndices = InputParser.convertUserLettersToIndices(userAnswer, " +");

            if(quizTest.submitAnswer(answerIndices)) {
                System.out.println("|| Poprawne odpowiedzi.    ||");
            } else {
                System.out.println("|| Błędne odpowiedzi.   ||");
            }
            System.out.println("=============================\n");
        }
    }
}
