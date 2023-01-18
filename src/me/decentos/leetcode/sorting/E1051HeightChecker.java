package me.decentos.leetcode.sorting;

import java.util.Arrays;

public class E1051HeightChecker {

    public int heightChecker(int[] heights) {
        int[] expected = heights.clone();
        int count = 0;
        Arrays.sort(expected);
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                count++;
            }
        }
        return count;
    }

    public int heightChecker2(int[] heights) {
        int[] counter = new int[101];
        for (int i : heights) counter[i]++;

        int result = 0, curr = 0;
        for (int height : heights) {
            while (counter[curr] == 0) curr++;
            if (curr != height) result++;
            counter[curr]--;
        }
        return result;
    }
}
