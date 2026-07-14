package quizapp.service.scoring;

import java.util.List;

public class MultipleChoicePenalizingScoring implements ScoringStrategy{

    @Override
    public double calculateScore(List<Integer> chosenAnswers, List<Integer> correctAnswers, int totalOptionsCount) {
        if(chosenAnswers.isEmpty() || chosenAnswers.size() > correctAnswers.size()) {
            System.out.println("Za pytanie: 0.0");
            return 0.0;
        }
        if(chosenAnswers.size() == correctAnswers.size() && chosenAnswers.containsAll(correctAnswers)) {
            System.out.println("Za pytanie: 1.0");
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
            System.out.println("Za pytanie: "+Math.max(0.0, pointsForAnswer));
            return Math.max(0.0, pointsForAnswer);
        }
    }
}
