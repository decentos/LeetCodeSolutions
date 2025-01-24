package binarysearch;

public class M33SearchRotatedArray {

    public int search(int[] nums, int target) {
        int n = nums.length;
        int pivot = findPivotIndex(nums);

        if (nums[n - 1] >= target) {
            return findTarget(nums, pivot, n - 1, target);
        } else {
            return findTarget(nums, 0, pivot - 1, target);
        }
    }

    private int findPivotIndex(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[nums.length - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private int findTarget(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
