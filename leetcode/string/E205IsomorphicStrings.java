package string;

import java.util.HashMap;
import java.util.Map;

public class E205IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        Map<Character, Character> mapS = new HashMap<>();
        Map<Character, Character> mapT = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (mapS.containsKey(sChar) && mapS.get(sChar) != tChar) {
                return false;
            }
            if (mapT.containsKey(tChar) && mapT.get(tChar) != sChar) {
                return false;
            }
            mapS.put(sChar, tChar);
            mapT.put(tChar, sChar);
        }
        return true;
    }
}
