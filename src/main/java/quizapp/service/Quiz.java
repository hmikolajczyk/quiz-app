package quizapp.service;
import java.util.List;

import quizapp.model.Question;
import quizapp.service.scoring.ScoringStrategy;

public class Quiz {
    private final List<Question> questionList;
    private int questionIndex;
    private double userPoints;
    private final ScoringStrategy scoringStrategy;

    public Quiz(List<Question> questionList, ScoringStrategy scoringStrategy) {
        if(questionList == null || questionList.isEmpty()) {
            throw new IllegalArgumentException("Lista pytań nie może być pusta ani nullem!");
        }
        if(scoringStrategy == null) {
            throw new IllegalArgumentException("ScoringStrategy nie może być nullem!");
        }

        this.questionList = questionList;
        this.scoringStrategy = scoringStrategy;
        questionIndex = 0;
        userPoints = 0.0;
    }

    public double getUserPoints() {
        return userPoints;
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

    public boolean hasNextQuestion() {
        return questionIndex<questionList.size();
    }

    public boolean submitAnswer(List<Integer> chosenAnswers) {
        Question currentQuestion = getCurrentQuestion();
        double scoredPoints = scoringStrategy.calculateScore(chosenAnswers, currentQuestion.getCorrectAnswersIndex(), currentQuestion.getAnswerOptions().size());
        userPoints += scoredPoints;
        nextQuestion();
        return scoredPoints > 0.0;
    }
}
