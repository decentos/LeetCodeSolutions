package slidingwindow;

public class M1004MaxConsecutiveOnes3 {

    public int longestOnes(int[] nums, int k) {
        int max = 0, zeroCount = 0, left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
