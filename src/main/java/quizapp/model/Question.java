package quizapp.model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question {
    private final QuestionType questionType;
    private final String questionText;
    private final List<String> answerOptions;
    private final List<Integer> correctAnswersIndex;

    public Question(QuestionType questionType, String questionText, List<String> answerOptions, List<Integer> correctAnswersIndex) {
        this.questionType = questionType;
        this.questionText = questionText;
        this.answerOptions = answerOptions;
        List<Integer> sortedCorrectAnswersIndex = new ArrayList<>(correctAnswersIndex);
        Collections.sort(sortedCorrectAnswersIndex);
        this.correctAnswersIndex = sortedCorrectAnswersIndex;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }
    public String getQuestionText() {
        return questionText;
    }
    public List<String> getAnswerOptions() {
        return answerOptions;
    }
    public List<Integer> getCorrectAnswersIndex() {
        return correctAnswersIndex;
    }
}
