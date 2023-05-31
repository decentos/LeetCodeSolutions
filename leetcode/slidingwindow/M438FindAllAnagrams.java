package slidingwindow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M438FindAllAnagrams {

    public static List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) return Collections.emptyList();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            String letter = String.valueOf(s.charAt(i));
            if (p.contains(letter) && i + p.length() <= s.length()) {
                if (isAnagram(p, s.substring(i, i + p.length()))) {
                    result.add(i);
                }
            }
        }
        return result;
    }

    private static boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }

    public static List<Integer> findAnagrams2(String s, String p) {
        if (s.length() < p.length()) return Collections.emptyList();

        List<Integer> result = new ArrayList<>();
        int[] hashmap = new int[128];
        for (char ch : p.toCharArray()) {
            hashmap[ch]++;
        }
        int start = 0, end = 0, counter = p.length();

        while (end < s.length()) {
            if (hashmap[s.charAt(end++)]-- > 0) counter--;
            if (counter == 0) result.add(start);
            if (end - start == p.length() && hashmap[s.charAt(start++)]++ >= 0) counter++;
        }
        return result;
    }

    public static List<Integer> findAnagrams3(String s, String p) {
        if (s.length() < p.length()) return Collections.emptyList();

        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            map.merge(p.charAt(i), 1, Integer::sum);
        }

        int start = 0, end = 0, counter = map.size();
        while (end < s.length()) {
            char eChar = s.charAt(end);
            Integer eCount = map.get(eChar);
            if (eCount != null) {
                if (eCount == 1) {
                    counter--;
                }
                map.put(eChar, eCount - 1);
            }
            end++;

            if (end - start > p.length()) {
                char sChar = s.charAt(start);
                Integer sCount = map.get(sChar);
                if (sCount != null) {
                    if (sCount == 0) {
                        counter++;
                    }
                    map.put(sChar, sCount + 1);
                }
                start++;
            }

            if (counter == 0) {
                result.add(start);
            }
        }
        return result;
    }
}
