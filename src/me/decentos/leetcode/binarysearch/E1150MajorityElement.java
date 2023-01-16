package me.decentos.leetcode.binarysearch;

public class E1150MajorityElement {

    public boolean isMajorityElement(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = (high + low) / 2;
            if (nums[mid] == target) {
                int midDup = mid - 1;
                int count = 0;
                while (mid < nums.length && nums[mid] == target) {
                    count++;
                    mid++;
                }
                while (midDup >= 0 && nums[midDup] == target) {
                    count++;
                    midDup--;
                }
                return count > nums.length / 2;
            } else if (nums[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }
}
