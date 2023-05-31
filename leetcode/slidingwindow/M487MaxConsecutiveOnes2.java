package slidingwindow;

public class M487MaxConsecutiveOnes2 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int maxCount = 0, lastZero = 0, index = 0;
        while (index < n) {
            int currMax = 0;
            while (index < n && nums[index] != 0) {
                currMax++;
                index++;
            }
            if (index < n) {
                lastZero = index;
                index++;
                currMax++;
                while (index < n && nums[index] != 0) {
                    currMax++;
                    index++;
                }
                index = lastZero + 1;
            }
            maxCount = Math.max(maxCount, currMax);
        }
        return maxCount;
    }

    public int findMaxConsecutiveOnes2(int[] nums) {
        int maxCount = 0, numZeroes = 0;
        int left = 0, right = 0;

        while (right < nums.length) {
            if (nums[right] == 0) numZeroes++;

            while (numZeroes == 2) {
                if (nums[left] == 0) {
                    numZeroes--;
                }
                left++;
            }
            maxCount = Math.max(maxCount, right - left + 1);
            right++;
        }
        return maxCount;
    }
}
