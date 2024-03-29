package slidingwindow;

public class M2962CountSubarrays {

    public long countSubarrays(int[] nums, int k) {
        int max = 0, maxCount = 0, left = 0;
        long count = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        for (int num : nums) {
            if (num == max) {
                maxCount++;
            }

            while (maxCount >= k) {
                if (nums[left] == max) {
                    maxCount--;
                }
                left++;
            }
            count += left;
        }
        return count;
    }

}
