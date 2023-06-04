package slidingwindow;

public class M487MaxConsecutiveOnes2 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0, lastZero = -1, max = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                left = lastZero + 1;
                lastZero = right;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    public int findMaxConsecutiveOnes2(int[] nums) {
        int prev = 0, curr = 0, max = 0;

        for (int num : nums) {
            if (num == 1) {
                curr++;
            } else {
                prev = curr + 1;
                curr = 0;
            }
            max = Math.max(max, curr + prev);
        }
        return max;
    }
}
