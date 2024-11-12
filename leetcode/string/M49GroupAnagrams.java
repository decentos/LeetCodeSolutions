package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M49GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();

        for (String word : strs) {
            char[] freq = new char[26];
            for (char letter : word.toCharArray()) {
                freq[letter - 'a']++;
            }
            String key = String.valueOf(freq);
            anagrams.computeIfAbsent(key, val -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(anagrams.values());
    }
}
