package twopointers;

import java.util.Arrays;

public class M16ThreeSumClosest {
    private int minDiff = Integer.MAX_VALUE;
    private int closestSum = Integer.MAX_VALUE;

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            sum(nums, i, target);
        }
        return closestSum;
    }

    private void sum(int[] nums, int index, int target) {
        int curr = nums[index], left = index + 1, right = nums.length - 1;

        while (left < right) {
            int sum = curr + nums[left] + nums[right];
            int diff = Math.abs(target - sum);

            if (diff < minDiff) {
                minDiff = diff;
                closestSum = sum;
            }

            if (sum < target) {
                left++;
                while (left < right && nums[left - 1] == nums[left]) left++;
            } else {
                right--;
                while (left < right && nums[right + 1] == nums[right]) right--;
            }
        }
    }
}
