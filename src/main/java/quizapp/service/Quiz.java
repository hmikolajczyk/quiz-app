package quizapp.service;
import java.util.List;
import quizapp.model.Question;

public class Quiz {
    private final List<Question> questionList;
    private int userPoints;

    public Quiz(List<Question> questionList) {
        if(questionList == null || questionList.isEmpty()) {
            throw new IllegalArgumentException("Lista pytań nie może być pusta ani nullem!");
        }
        
        this.questionList = questionList;
        userPoints = 0;
    }
}
