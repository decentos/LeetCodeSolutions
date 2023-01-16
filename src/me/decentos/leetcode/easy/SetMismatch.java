package me.decentos.leetcode.easy;

import java.util.Arrays;

public class SetMismatch {

    public static int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int duplicate = -1;
        int missing = 1;
        for (int i = 1; i < nums.length; i++) {
            if (duplicate == -1 && nums[i] == nums[i - 1]) {
                duplicate = nums[i];
            } else if (nums[i] > nums[i - 1] + 1) {
                missing = nums[i - 1] + 1;
            }
        }
        if (duplicate != -1) {
            return new int[]{duplicate, nums[nums.length - 1] != nums.length ? nums.length : missing};
        } else {
            return new int[]{};
        }
    }
}
