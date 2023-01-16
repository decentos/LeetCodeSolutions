package me.decentos.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class E290WordPattern {

    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;

        Map<String, Character> wordsMap = new HashMap<>();
        Map<Character, String> patternMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            String wordFromMap = patternMap.get(c);
            Character charFromMap = wordsMap.get(word);

            if (wordFromMap == null && charFromMap == null) {
                wordsMap.put(word, c);
                patternMap.put(c, word);
            } else if (wordFromMap == null || charFromMap == null || !wordFromMap.equals(word) || !charFromMap.equals(c)) {
                return false;
            }
        }
        return true;
    }
}
