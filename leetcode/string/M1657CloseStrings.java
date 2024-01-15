package string;

import java.util.HashMap;
import java.util.Map;

public class M1657CloseStrings {

    public boolean closeStrings(String word1, String word2) {
        int[] counter1 = calculateLetters(word1);
        int[] counter2 = calculateLetters(word2);
        for (int i = 0; i < counter1.length; i++) {
            if (counter1[i] > 0 && counter2[i] == 0 || counter2[i] > 0 && counter1[i] == 0) {
                return false;
            }
        }

        Map<Integer, Integer> occurs1 = calculateOccurs(counter1);
        Map<Integer, Integer> occurs2 = calculateOccurs(counter2);
        return occurs1.equals(occurs2);
    }

    private int[] calculateLetters(String word) {
        int[] counter = new int[26];
        for (char c : word.toCharArray()) {
            counter[c - 'a']++;
        }
        return counter;
    }

    private Map<Integer, Integer> calculateOccurs(int[] counter) {
        Map<Integer, Integer> occurs = new HashMap<>();
        for (int i : counter) {
            occurs.merge(i, 1, Integer::sum);
        }
        return occurs;
    }
}
