package quizapp.service.scoring;

import java.util.List;

public class SingleChoicePenalizingScoring implements ScoringStrategy{

    private final double penaltyRate;

    public SingleChoicePenalizingScoring(double penaltyRate) {
        if(penaltyRate < 0) {
            this.penaltyRate = penaltyRate * (-1);
        } else {
            this.penaltyRate = penaltyRate;
        }
    }

    @Override
    public double calculateScore(List<Integer> chosenAnswers, List<Integer> correctAnswers) {
        if(chosenAnswers.size() != 1) {
            return 0.0;
        }
        if(chosenAnswers.equals(correctAnswers)) {
            return 1.0;
        }
        return -penaltyRate;
    }
}
