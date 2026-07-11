package quizapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import quizapp.model.Question;
import quizapp.model.QuestionType;
import quizapp.service.Quiz;

public class Main {
    public static void main(String[] args) {
        Question question1 = new Question(QuestionType.SINGLE_CHOICE, "Treść pytania nr 1", List.of("A: Opcja A", "B: Opcja B", "C: Opcja C"), List.of(0));

        Question question2 = new Question(QuestionType.SINGLE_CHOICE, "Treść pytania nr 2", List.of("A: Opcja A", "B: Opcja B", "C: Opcja C"), List.of(1));

        List<Question> questions = List.of(question1, question2);
        Quiz quizTest = new Quiz(questions);

        System.out.println(quizTest.getCurrentQuestion().getQuestionText());

        Scanner scanner = new Scanner(System.in);

        String userAnswer = scanner.nextLine().toLowerCase();
        String[] splitAnswers = userAnswer.split(" ");
        List<Integer> answerIndexes = new ArrayList<>();

        for(String answer : splitAnswers) {
            char letter = answer.charAt(0);
            int index = letter - 'a';
            answerIndexes.add(index);
        }

        System.out.println("Indeksy: " + answerIndexes);
    }
}
