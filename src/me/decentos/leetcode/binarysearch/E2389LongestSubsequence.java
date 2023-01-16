package me.decentos.leetcode.binarysearch;

import java.util.Arrays;

public class E2389LongestSubsequence {

    public int[] answerQueries(int[] nums, int[] queries) {
        int[] answers = new int[queries.length];
        Arrays.sort(nums);
        for (int i = 0; i < queries.length; i++) {
            int sub = 0;
            int curr = queries[i];
            for (int num : nums) {
                if (curr - num >= 0) {
                    sub++;
                    curr -= num;
                } else {
                    break;
                }
            }
            answers[i] = sub;
        }
        return answers;
    }

    public static int[] answerQueries2(int[] nums, int[] queries) {
        int[] answers = new int[queries.length];
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        for (int i = 0; i < queries.length; i++) {
            int low = 0, high = nums.length - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                int numsMid = nums[mid];
                if (numsMid > queries[i]) high = mid - 1;
                else low = mid + 1;
            }
            answers[i] = low;
        }
        return answers;
    }
}
