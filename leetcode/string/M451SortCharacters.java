package string;

import java.util.*;

public class M451SortCharacters {

    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }

        map.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .forEach(entry -> sb.append(String.valueOf(entry.getKey()).repeat(entry.getValue())));
        return sb.toString();
    }

    public String frequencySort2(String s) {
        Map<Character, Integer> letters = new HashMap<>();
        for (char c : s.toCharArray()) {
            letters.merge(c, 1, Integer::sum);
        }
        Map<Integer, List<Character>> count = new HashMap<>();
        letters.forEach((k, v) -> count.computeIfAbsent(v, val -> new ArrayList<>()).add(k));

        int max = Collections.max(count.keySet());
        StringBuilder ans = new StringBuilder();

        for (int i = max; i > 0; i--) {
            if (count.containsKey(i)) {
                List<Character> curr = count.get(i);
                for (char c : curr) {
                    ans.append(String.valueOf(c).repeat(i));
                }
            }
        }
        return ans.toString();
    }
}
