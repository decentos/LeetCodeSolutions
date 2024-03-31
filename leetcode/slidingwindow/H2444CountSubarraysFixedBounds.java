package slidingwindow;

public class H2444CountSubarraysFixedBounds {

    public long countSubarrays(int[] nums, int minK, int maxK) {
        int start = 0, minIndex = -1, maxIndex = -1;
        long count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                start = i + 1;
            }
            if (nums[i] == minK) {
                minIndex = i;
            }
            if (nums[i] == maxK) {
                maxIndex = i;
            }
            count += Math.max(0, Math.min(minIndex, maxIndex) - start + 1);
        }
        return count;
    }
}
