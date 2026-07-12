package quizapp.service.scoring;

import java.util.List;

public class MultipleChoiceStandardScoring implements ScoringStrategy{

    @Override
    public double calculateScore(List<Integer> chosenAnswers, List<Integer> correctAnswers) {
        if(chosenAnswers.isEmpty()) {
            return 0.0;
        }
        if(chosenAnswers.equals(correctAnswers)) {
            return 1.0;
        }else {
            double pointsForAnswer = 0.0;
            for(Integer answer : chosenAnswers) {
                if(correctAnswers.contains(answer)) {
                    pointsForAnswer += (1.0/correctAnswers.size());
                }
            }
            return pointsForAnswer;
        }
    }
}
