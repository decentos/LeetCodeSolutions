package uber.algo;

public class M153FindMinimumRotatedArray {

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[0] && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            } else if (nums[mid] < nums[0]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return nums[0];
    }
}
