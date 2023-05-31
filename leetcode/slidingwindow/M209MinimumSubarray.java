package slidingwindow;

public class M209MinimumSubarray {

    public static int minSubArrayLen(int target, int[] nums) {
        int l = 0, sum = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            while (sum >= target) {
                min = Math.min(min, i + 1 - l);
                sum -= nums[l];
                l++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
