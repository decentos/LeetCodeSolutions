package me.decentos.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
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

    public int[] kWeakestRows2(int[][] mat, int k) {
        int[] weakest = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> map.get(n1) == map.get(n2) ? Integer.compare(n1, n2) : Integer.compare(map.get(n1), map.get(n2)));

        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) count++;
            }
            map.put(i, count);
        }

        for (int i = 0; i < mat.length; i++) {
            heap.offer(i);
        }

        for (int i = 0; i < k; i++) {
            weakest[i] = heap.poll();
        }
        return weakest;
    }

    public int[] kWeakestRows3(int[][] mat, int k) {
        int[] weakest = new int[k];
        int weakestIndex = 0;

        for (int column = 0; column < mat[0].length && weakestIndex < k; column++) {
            for (int row = 0; row < mat.length && weakestIndex < k; row++) {
                if (mat[row][column] == 0 && (column == 0 || mat[row][column - 1] == 1)) {
                    weakest[weakestIndex] = row;
                    weakestIndex++;
                }
            }
        }

        for (int row = 0; weakestIndex < k; row++) {
            if (mat[row][mat[0].length - 1] == 1) {
                weakest[weakestIndex] = row;
                weakestIndex++;
            }
        }
        return weakest;
    }
}
