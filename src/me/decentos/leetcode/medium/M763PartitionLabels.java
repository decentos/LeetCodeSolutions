package me.decentos.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M763PartitionLabels {

    public List<Integer> partitionLabels(String s) {
        if (s.length() == 1) return Collections.singletonList(1);
        List<Integer> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], i);
        }



        return result;
    }
}
