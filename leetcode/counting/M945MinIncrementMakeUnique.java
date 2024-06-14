package counting;

import java.util.Arrays;

public class M945MinIncrementMakeUnique {

    public int minIncrementForUniqueGreedy(int[] nums) {
        Arrays.sort(nums);
        int count = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] >= nums[i]) {
                int diff = nums[i - 1] - nums[i] + 1;
                nums[i] += diff;
                count += diff;
            }
        }
        return count;
    }

// ===============================================================================

    public int minIncrementForUnique(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int[] count = new int[nums.length + max];

        for (int num : nums) {
            count[num]++;
        }

        int increments = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] <= 1) {
                continue;
            }

            int carry = count[i] - 1;
            count[i + 1] += carry;
            increments += carry;
        }
        return increments;
    }
}
