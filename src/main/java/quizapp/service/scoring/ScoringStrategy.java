package quizapp.service.scoring;

import java.util.List;

public interface ScoringStrategy {

    public double calculateScore(List<Integer> chosenAnswers, List<Integer> correctAnswers);
}
