package binarysearch;

import java.util.Arrays;

public class E1608SpecialElementsGreater {

    public int specialArray(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        for (int i = 1; i <= n; i++) {
            int greaterCount = binarySearch(nums, i);
            if (n - greaterCount == i) {
                return i;
            }
        }
        return -1;
    }

    private int binarySearch(int[] nums, int curr) {
        int n = nums.length, index = n;
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] < curr) {
                left = mid + 1;
            } else {
                index = mid;
                right = mid - 1;
            }
        }
        return index;
    }
}
