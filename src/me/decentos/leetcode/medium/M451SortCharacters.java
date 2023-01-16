package me.decentos.leetcode.medium;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class M451SortCharacters {

    public String frequencySort(String s) {
        if (s.length() < 3) return s;

        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) map.merge(c, 1, Integer::sum);

        map.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .forEach(entry -> {
                    for (int i = 0; i < entry.getValue(); i++) {
                        sb.append(entry.getKey());
                    }
                });
                // .forEach(entry -> sb.append(String.valueOf(entry.getKey()).repeat(entry.getValue())));
        return sb.toString();
    }
}
