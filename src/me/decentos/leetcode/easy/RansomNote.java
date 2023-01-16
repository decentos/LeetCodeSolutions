package me.decentos.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;

        Map<Character, Integer> map = new HashMap<>();
        char[] magazineChars = magazine.toCharArray();
        for (char c : magazineChars) {
            map.merge(c, 1, Integer::sum);
        }
        char[] noteChars = ransomNote.toCharArray();
        for (char c : noteChars) {
            Integer count = map.get(c);
            if (count == null || count == 0) return false;
            count--;
            map.put(c, count);
        }
        return true;
    }
}
