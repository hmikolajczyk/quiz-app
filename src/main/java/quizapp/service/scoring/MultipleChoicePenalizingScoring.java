package quizapp.service.scoring;

import java.util.List;

public class MultipleChoicePenalizingScoring implements ScoringStrategy{

    @Override
    public double calculateScore(List<Integer> chosenAnswers, List<Integer> correctAnswers, int totalOptionsCount) {
        if(chosenAnswers.isEmpty() || chosenAnswers.size() > correctAnswers.size()) {
            return 0.0;
        }
        if(chosenAnswers.size() == correctAnswers.size() && chosenAnswers.containsAll(correctAnswers)) {
            return 1.0;
        }else {
            double pointsForAnswer = 0.0;
            for(int i = 0; i<totalOptionsCount;i++) {
                if(correctAnswers.contains(i)) {
                    if(chosenAnswers.contains(i)) {
                        pointsForAnswer += (1.0/correctAnswers.size());
                    } else {
                        pointsForAnswer -=(1.0/correctAnswers.size());
                    }
                } else if(chosenAnswers.contains(i)) {
                    pointsForAnswer -=(1.0/correctAnswers.size());
                }
            }
            return Math.max(0.0, pointsForAnswer);
        }
    }
}
