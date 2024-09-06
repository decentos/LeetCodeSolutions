package slidingwindow;

public class M1493LongestAfterDeleting {

    public int longestSubarray(int[] nums) {
        int skippedZeros = 0, max = 0, left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                skippedZeros++;
            }

            while (skippedZeros > 1) {
                if (nums[left] == 0) {
                    skippedZeros--;
                }
                left++;
            }

            max = Math.max(max, right - left);
        }
        return max;
    }
}
