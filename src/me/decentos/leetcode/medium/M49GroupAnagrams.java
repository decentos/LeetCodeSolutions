package me.decentos.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M49GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : strs) {
            char[] wordArr = word.toCharArray();
            Arrays.sort(wordArr);
            String sortWord = new String(wordArr);

            List<String> list = map.get(sortWord);
            if (list == null) {
                map.put(sortWord, List.of(word));
            } else {
                List<String> arraylist = new ArrayList<>(list);
                arraylist.add(word);
                map.put(sortWord, arraylist);
            }
        }
        return new ArrayList<>(map.values());
    }
}
