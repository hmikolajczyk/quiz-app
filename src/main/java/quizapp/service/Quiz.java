package quizapp.service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import quizapp.model.Question;

public class Quiz {
    private final List<Question> questionList;
    private int questionIndex;
    private int userPoints;

    public Quiz(List<Question> questionList) {
        if(questionList == null || questionList.isEmpty()) {
            throw new IllegalArgumentException("Lista pytań nie może być pusta ani nullem!");
        }

        this.questionList = questionList;
        questionIndex = 0;
        userPoints = 0;
    }

    public Question getCurrentQuestion() {
        if(questionIndex < 0 || questionIndex >= questionList.size()) {
            throw new IndexOutOfBoundsException("Skończyły się pytania!");
        }
        return questionList.get(questionIndex);
    }

    public void nextQuestion() {
        questionIndex++;
    }

    public boolean isAnswerCorrect(List<Integer> chosenAnswers) {
        Question currentQuestion = getCurrentQuestion();
        List<Integer> correctAnswers = currentQuestion.getCorrectAnswersIndex();
        List<Integer> sortedChosenAnswers = new ArrayList<>(chosenAnswers);
        Collections.sort(sortedChosenAnswers);
        
        return sortedChosenAnswers.equals(correctAnswers);
    }
}
