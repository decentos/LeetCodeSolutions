package me.decentos.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> letters = new HashMap<>();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] == tChars[i]) continue;
            Character current = letters.get(sChars[i]);
            if ((current != null && !current.equals(tChars[i])) || isKeyNotMatch(letters, sChars[i], tChars[i])) return false;
            if (current == null) letters.put(sChars[i], tChars[i]);
        }
        return true;
    }
    
    private static boolean isKeyNotMatch(Map<Character, Character> letters, Character sChar, Character tChar) {
        Character currentKey = null;
        for (Map.Entry<Character, Character> entry : letters.entrySet()) {
            if (entry.getValue().equals(tChar)) {
                currentKey = entry.getKey();
            }
        }
        return currentKey != null && !currentKey.equals(sChar);
    }

    public boolean isIsomorphic2(String s, String t) {
        Map<Character, Character> fromStoT = new HashMap<>();
        Map<Character, Character> fromTtoS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            Character valueS = fromStoT.get(sChar);
            Character valueT = fromTtoS.get(tChar);
            if (valueS == null && valueT == null) {
                fromStoT.put(sChar, tChar);
                fromTtoS.put(tChar, sChar);
            } else if ((valueS != null && !valueS.equals(tChar))
                    || (valueT != null && !valueT.equals(sChar))) {
                return false;
            }
        }
        return true;
    }
}
