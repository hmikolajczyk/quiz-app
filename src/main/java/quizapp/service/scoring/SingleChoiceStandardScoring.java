package quizapp.service.scoring;

import java.util.List;

public class SingleChoiceStandardScoring implements ScoringStrategy{

    @Override
    public double calculateScore(List<Integer> chosenAnswers, List<Integer> correctAnswers) {
        if(chosenAnswers.size() != 1) {
            return 0.0;
        }
        if(chosenAnswers.equals(correctAnswers)) {
            return 1.0;
        }
        return 0.0;
    }
}
