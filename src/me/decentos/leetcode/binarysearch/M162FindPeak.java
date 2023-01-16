package me.decentos.leetcode.binarysearch;

public class M162FindPeak {

    public static int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cur = nums[mid];
            if ((mid - 1 == -1 || cur > nums[mid - 1])
                    && (mid + 1 == nums.length || cur > nums[mid + 1])) return mid;
            else if (mid + 1 < nums.length && cur < nums[mid + 1]) low = mid + 1;
            else high = mid;
        }
        return -1;
    }

    public int findPeakElement2(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}
