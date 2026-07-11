package quizapp.service;
import java.util.List;
import quizapp.model.Question;
import quizapp.model.QuestionType;

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

    public boolean isAnswerCorrect(int choosenAnswer) {
        Question currentQuestion = getCurrentQuestion();
        List<Integer> correctAnswers = currentQuestion.getCorrectAnswersIndex();
        if(currentQuestion.getQuestionType() == QuestionType.SINGLE_CHOICE) {
            if(correctAnswers.get(0) == choosenAnswer) {
                userPoints++;
                return true;
            }
        }
        // TODO: Sprawdzenie pytania wielokrotnej odpowiedzi
        return false;
    }
}
