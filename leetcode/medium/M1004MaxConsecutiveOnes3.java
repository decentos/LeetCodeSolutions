package medium;

public class M1004MaxConsecutiveOnes3 {

    public int longestOnes(int[] nums, int k) {
        int subCount = 0, zeroCount = 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] == 0) zeroCount++;

            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            subCount = Math.max(subCount, right - left + 1);
            right++;
        }
        return subCount;
    }

    public int longestOnes2(int[] nums, int k) {
        int left = 0, right;
        for (right = 0; right < nums.length; right++) {
            if (nums[right] == 0) k--;

            if (k < 0) {
                k += 1 - nums[left];
                left++;
            }
        }
        return right - left;
    }
}
