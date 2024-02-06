package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M49GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sorted = String.valueOf(chars);
            map.computeIfAbsent(sorted, val -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : strs) {
            char[] count = new char[26];
            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }
            String key = String.valueOf(count);
            map.computeIfAbsent(key, val -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(map.values());
    }
}
