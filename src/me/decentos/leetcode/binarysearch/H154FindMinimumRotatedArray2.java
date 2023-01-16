package me.decentos.leetcode.binarysearch;

public class H154FindMinimumRotatedArray2 {

    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;

        if (nums.length == 1 || nums[high] > nums[0]) return nums[0];

        while (low <= high) {
            int mid = (low + high) / 2;
            int current = nums[mid];
            if (current > nums[high]) low = mid + 1;
            else if (current < nums[high]) high = mid;
            else high -= 1;
        }
        return nums[low];
    }
}
