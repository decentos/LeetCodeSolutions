package dp;

public class M53MaximumSubarray {

    // Kadane's algorithm
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE, currSum = 0;

        for (int num : nums) {
            currSum += num;
            maxSum = Math.max(maxSum, currSum);
            if (currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }
}
