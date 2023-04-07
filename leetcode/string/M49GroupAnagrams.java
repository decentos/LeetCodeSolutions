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
            char[] wordArr = word.toCharArray();
            Arrays.sort(wordArr);
            String sortWord = new String(wordArr);
            map.computeIfAbsent(sortWord, val -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        int[] count = new int[26];
        for (String word : strs) {
            Arrays.fill(count, 0);
            for (char c : word.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder();
            for (int j : count) {
                sb.append('#');
                sb.append(j);
            }
            map.computeIfAbsent(sb.toString(), val -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(map.values());
    }
}
