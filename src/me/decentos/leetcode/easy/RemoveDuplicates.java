package me.decentos.leetcode.easy;

public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        int cur = 0, next = 1;

        while (next < nums.length) {
            if (nums[cur] == nums[next]) {
                nums[next] = -101;
            } else {
                int temp = nums[cur + 1];
                nums[cur + 1] = nums[next];
                nums[next] = temp;
                cur++;
            }
            next++;
        }
        return cur + 1;
    }

    public static int removeDuplicates2(int[] nums) {
        int curIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[curIndex] = nums[i];
                curIndex++;
            }
        }
        return curIndex;
    }
}
