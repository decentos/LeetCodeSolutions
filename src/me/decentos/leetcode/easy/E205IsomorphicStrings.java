package me.decentos.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class E205IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            Character fromMap1 = map1.get(charS);
            Character fromMap2 = map2.get(charT);
            if (fromMap1 == null && fromMap2 == null) {
                map1.put(charS, charT);
                map2.put(charT, charS);
            } else if (fromMap1 == null || fromMap2 == null || !fromMap1.equals(charT) || !fromMap2.equals(charS)) {
                return false;
            }
        }
        return true;
    }
}
