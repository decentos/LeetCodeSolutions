package medium;

import java.util.HashMap;
import java.util.Map;

public class M299BullsCows {

    public static String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> cowsMap = new HashMap<>();
        char[] secretChars = secret.toCharArray();
        for (char c : secretChars) {
            map.merge(c, 1, Integer::sum);
        }

        for (int i = 0; i < secret.length(); i++) {
            char secretC = secret.charAt(i);
            char guessC = guess.charAt(i);
            Integer fromMap = map.get(guessC);
            if (secretC == guessC && fromMap > 0) {
                bulls++;
                fromMap--;
                map.put(guessC , fromMap);
            } else if (fromMap != null && fromMap > 0) {
                cowsMap.merge(guessC, 1, Integer::sum);
            }
        }
        for (int i = 0; i < secret.length(); i++) {
            char guessC = guess.charAt(i);
            Integer fromMap = map.get(guessC);
            Integer fromCowsMap = cowsMap.get(guessC);
            if (fromCowsMap != null && fromCowsMap > 0 && fromMap != null && fromMap > 0) {
                cows++;
                fromMap--;
                map.put(guessC , fromMap);
                fromCowsMap--;
                cowsMap.put(guessC , fromCowsMap);
            }
        }
        return String.format("%dA%dB", bulls, cows);
    }
}
