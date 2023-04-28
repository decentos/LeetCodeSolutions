package twopointers;

import java.util.Arrays;

public class M259ThreeSumSmaller {

    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);

        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            count += sum(nums, i, target);
        }
        return count;
    }

    private int sum(int[] nums, int index, int target) {
        int curr = nums[index], left = index + 1, right = nums.length - 1;
        int count = 0;

        while (left < right) {
            int sum = curr + nums[left] + nums[right];

            if (sum < target) {
                count += right - left;
                left++;
            } else {
                right--;
                while (left < right && nums[right + 1] == nums[right]) right--;
            }
        }
        return count;
    }
}
