package quizapp.util;

import java.util.ArrayList;
import java.util.List;

public class InputParser {
    public static List<Integer> convertUserLettersToIndices(String input,  String regex) {
        String[] splitAnswers = input.trim().toLowerCase().split(regex);
        List<Integer> answerIndices = new ArrayList<>();

        for(String answer : splitAnswers) {
            char letter = answer.charAt(0);
            int index = letter - 'a';
            answerIndices.add(index);
        }

        return answerIndices;
    }
}
