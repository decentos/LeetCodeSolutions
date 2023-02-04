package binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E2089FindTargetIndices {

    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        int low = 0, high = nums.length - 1;
        int left = -1, right = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                left = mid;
                right = mid;
                while (left >= 0 && nums[left] == target) {
                    left--;
                }
                while (right < nums.length && nums[right] == target) {
                    right++;
                }
                break;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        for (int i = left + 1; i < right; i++) {
            result.add(i);
        }
        return result;
    }
}
