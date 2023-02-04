package easy;

import java.util.Arrays;

public class E1099SumLessK {

    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1, result = -1;

        while (l < r) {
            if (nums[r] >= k) {
                r--;
            }
            int sum = nums[l] + nums[r];
            if (sum < k) {
                result = Math.max(sum, result);
                l++;
            } else {
                r--;
            }
        }
        return result;
    }
}
