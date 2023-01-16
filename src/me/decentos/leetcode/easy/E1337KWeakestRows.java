package me.decentos.leetcode.easy;

import java.util.Map;
import java.util.TreeMap;

public class E1337KWeakestRows {

    public static int[] kWeakestRows(int[][] mat, int k) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) count++;
            }
            map.put(i, count);
        }
        return map.entrySet().stream()
                 .sorted(Map.Entry.comparingByValue())
                 .limit(k)
                 .map(Map.Entry::getKey)
                 .mapToInt(it -> it)
                 .toArray();
    }
}
