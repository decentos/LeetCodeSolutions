package easy;

public class E643MaxAverageSubarray {

    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length, sum = 0, max = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        max = sum;
        for (int i = k; i < n; i++) {
            sum = sum - nums[i - k] + nums[i];
            max = Math.max(max, sum);
        }
        return (double) max / k;
    }
}
