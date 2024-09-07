package hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class M288UniqueWordAbbreviation {
    private final Map<String, Set<String>> map;

    public M288UniqueWordAbbreviation(String[] dictionary) {
        map = new HashMap<>();
        for (String word : dictionary) {
            String abbr = toAbbr(word);
            map.computeIfAbsent(abbr, val -> new HashSet<>()).add(word);
        }
    }

    public boolean isUnique(String word) {
        String abbr = toAbbr(word);
        Set<String> set = map.get(abbr);
        return set == null || (set.size() == 1 && set.contains(word));
    }

    private String toAbbr(String word) {
        int n = word.length();
        if (n < 3) return word;
        else return String.valueOf(word.charAt(0)) + (n - 2) + word.charAt(n - 1);
    }
}
