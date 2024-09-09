package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M1657CloseStrings {

    public boolean closeStrings(String word1, String word2) {
        Map<Character, Integer> letters1 = new HashMap<>();
        Map<Character, Integer> letters2 = new HashMap<>();

        for (char c : word1.toCharArray()) {
            letters1.merge(c, 1, Integer::sum);
        }

        for (char c : word2.toCharArray()) {
            letters2.merge(c, 1, Integer::sum);
        }

        if (!letters1.keySet().equals(letters2.keySet())) {
            return false;
        }

        List<Integer> count1 = letters1.values().stream().sorted().toList();
        List<Integer> count2 = letters2.values().stream().sorted().toList();

        return count1.equals(count2);
    }

// ===============================================================================

    public boolean closeStrings2(String word1, String word2) {
        int n = 26;
        int[] letters1 = new int[n];
        int[] letters2 = new int[n];

        for (char c : word1.toCharArray()) {
            letters1[c - 'a']++;
        }

        for (char c : word2.toCharArray()) {
            letters2[c - 'a']++;
        }

        for (int i = 0; i < n; i++) {
            if (letters1[i] == 0 && letters2[i] > 0 || letters2[i] == 0 && letters1[i] > 0) {
                return false;
            }
        }

        Arrays.sort(letters1);
        Arrays.sort(letters2);
        return Arrays.equals(letters1, letters2);
    }
}
