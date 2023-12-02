package twopointers;

import java.util.Arrays;

public class E1099SumLessK {

    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int maxSum = -1;
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int currSum = nums[left] + nums[right];

            if (currSum < k) {
                maxSum = Math.max(maxSum, currSum);
                left++;
            } else {
                right--;
            }
        }
        return maxSum;
    }
}
