package binarysearch;

public class M162FindPeak {

    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isPeak(nums, mid)) {
                return mid;
            } else if (nums[mid] > nums[mid + 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private boolean isPeak(int[] nums, int index) {
        return (index == 0 || nums[index] > nums[index - 1]) && (index == nums.length - 1 || nums[index] > nums[index + 1]);
    }
}
