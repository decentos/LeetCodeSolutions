package me.decentos.leetcode.easy;

public class RunningSum {

    public static int[] runningSum(int[] nums) {
        int currentSum = 0;
        int[] resultArr = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            resultArr[i] = currentSum;
        }
        return resultArr;
    }

    public static int[] runningSum2(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
