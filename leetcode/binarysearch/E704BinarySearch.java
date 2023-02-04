package binarysearch;

public class E704BinarySearch {

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            if (nums[l] == target) return l;
            else if (nums[r] == target) return r;
            if (nums[l] < target) l++;
            if (nums[r] > target) r--;
        }
        return -1;
    }

    public static int search2(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return mid;
            else if (target > nums[mid]) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}
