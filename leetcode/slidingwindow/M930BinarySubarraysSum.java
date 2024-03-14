package slidingwindow;

public class M930BinarySubarraysSum {

    public int numSubarraysWithSum(int[] nums, int goal) {
        int left = 0, zeros = 0, sum = 0, count = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (left < right && (nums[left] == 0 || sum > goal)) {
                if (nums[left] == 0) {
                    zeros++;
                } else {
                    zeros = 0;
                }

                sum -= nums[left];
                left++;
            }

            if (sum == goal) {
                count += 1 + zeros;
            }
        }
        return count;
    }
}
