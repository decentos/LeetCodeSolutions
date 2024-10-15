package counting;

public class M164MaximumGap {

    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;

        int max = Integer.MIN_VALUE;
        for (int i : nums) max = Math.max(max, i);

        int place = 1;
        while (max / place > 0) {
            countingSort(nums, place);
            place *= 10;
        }

        int maxDiff = 0;
        for (int i = 1; i < nums.length; i++) {
            int currDiff = nums[i] - nums[i - 1];
            maxDiff = Math.max(maxDiff, currDiff);
        }
        return maxDiff;
    }

    private void countingSort(int[] nums, int place) {
        int[] sorted = new int[nums.length];
        int[] count = new int[10];

        for (int i : nums) {
            int curr = i / place;
            count[curr % 10]++;
        }

        int startIndex = 0;
        for (int i = 0; i < count.length; i++) {
            int curr = count[i];
            count[i] = startIndex;
            startIndex += curr;
        }

        for (int i : nums) {
            int curr = i / place;
            sorted[count[curr % 10]++] = i;
        }
        System.arraycopy(sorted, 0, nums, 0, nums.length);
    }
}
