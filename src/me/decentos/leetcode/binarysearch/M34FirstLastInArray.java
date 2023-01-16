package me.decentos.leetcode.binarysearch;

public class M34FirstLastInArray {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                while (mid >= 0 && nums[mid] == target) {
                    mid--;
                }
                mid++;
                res[0] = mid;
                while (mid < nums.length && nums[mid] == target) {
                    mid++;
                }
                mid--;
                res[1] = mid;
                return res;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }

    public int[] searchRange2(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};

        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) left = mid + 1;
            else right = mid;
        }

        int end = left - 1;
        if (end == -1 || nums[end] != target) return new int[]{-1, -1};

        left = 0;
        right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        return new int[]{left, end};
    }
}
