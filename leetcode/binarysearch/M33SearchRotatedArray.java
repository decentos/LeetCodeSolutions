package binarysearch;

public class M33SearchRotatedArray {

    public static int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int first = nums[low];
            int last = nums[high];
            int mid = low + (high - low) / 2;
            int cur = nums[mid];
            if (cur == target) return mid;
            else if (cur >= first) {
                if (target >= first && target < cur) high = mid - 1;
                else low = mid + 1;
            } else {
                if (target <= last && target > cur) low = mid + 1;
                else high = mid - 1;
            }
        }
        return -1;
    }
}
