package string;

import java.util.HashMap;
import java.util.Map;

public class E205IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> mapS = new HashMap<>();
        Map<Character, Character> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (!mapS.containsKey(sChar) && !mapT.containsKey(tChar)) {
                mapS.put(sChar, tChar);
                mapT.put(tChar, sChar);
            } else if (!mapS.containsKey(sChar) || !mapT.containsKey(tChar) || mapS.get(sChar) != tChar || mapT.get(tChar) != sChar) {
                return false;
            }
        }
        return true;
    }
}
