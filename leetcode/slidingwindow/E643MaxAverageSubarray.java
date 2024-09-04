package slidingwindow;

public class E643MaxAverageSubarray {

    public double findMaxAverage(int[] nums, int k) {
        int currSum = 0;

        for (int i = 0; i < k; i++) {
            currSum += nums[i];
        }

        int maxSum = currSum;

        for (int i = k; i < nums.length; i++) {
            currSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, currSum);
        }

        return (double) maxSum / k;
    }
}
