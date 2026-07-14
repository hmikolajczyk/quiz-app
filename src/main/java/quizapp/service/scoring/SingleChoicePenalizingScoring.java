package quizapp.service.scoring;

import java.util.List;

public class SingleChoicePenalizingScoring implements ScoringStrategy{

    private final double penaltyRate;

    public SingleChoicePenalizingScoring(double penaltyRate) {
        this.penaltyRate = Math.abs(penaltyRate);
        if(penaltyRate<=0&&penaltyRate>1) {
            throw new IllegalArgumentException("Kara musi mieścić się w zakresie (0.0; 1.0]!");
        }
    }

    @Override
    public double calculateScore(List<Integer> chosenAnswers, List<Integer> correctAnswers, int totalOptionsCount) {
        if(chosenAnswers.size() != 1) {
            return 0.0;
        }
        if(chosenAnswers.size() == correctAnswers.size() && chosenAnswers.containsAll(correctAnswers)) {
            return 1.0;
        }
        return -penaltyRate;
    }
}
