package binarysearch;

public class M153FindMinimumRotatedArray {

    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE, low = 0, high = nums.length - 1;

        if (nums.length == 1 || nums[high] > nums[0]) return nums[0];

        while (low <= high) {
            int mid = (low + high) / 2;
            int current = nums[mid];
            if (current < min) min = current;
            if (current > nums[high]) low = mid + 1;
            else high = mid - 1;
        }
        return min;
    }
}
