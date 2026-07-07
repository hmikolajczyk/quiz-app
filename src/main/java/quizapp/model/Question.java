package quizapp.model;
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
        this.correctAnswersIndex = correctAnswersIndex;
    }
}
