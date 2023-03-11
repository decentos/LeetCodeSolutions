package medium;

import java.util.Arrays;

public class M31NextPermutation {

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int curr = n - 2;
        while (curr >= 0 && nums[curr] >= nums[curr + 1]) curr--;

        if (curr >= 0) {
            int next = n - 1;
            while (nums[curr] >= nums[next]) next--;

            int temp = nums[curr];
            nums[curr] = nums[next];
            nums[next] = temp;
        }
        Arrays.sort(nums, curr + 1, n);
    }
}
