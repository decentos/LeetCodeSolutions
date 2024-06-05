package string;

import java.util.ArrayList;
import java.util.List;

public class E1002FindCommonCharacters {

    public List<String> commonChars(String[] words) {
        int[] prev = new int[26];

        for (char c : words[0].toCharArray()) {
            prev[c - 'a']++;
        }

        for (int i = 1; i < words.length; i++) {
            int[] curr = new int[26];

            for (char c : words[i].toCharArray()) {
                if (prev[c - 'a'] > 0) {
                    curr[c - 'a']++;
                    prev[c - 'a']--;
                }
            }
            prev = curr;
        }

        List<String> common = new ArrayList<>();
        for (int i = 0; i < prev.length; i++) {
            if (prev[i] > 0) {
                char letter = (char) ('a' + i);
                for (int count = 0; count < prev[i]; count++) {
                    common.add(String.valueOf(letter));
                }
            }
        }
        return common;
    }
}
