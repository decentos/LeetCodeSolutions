package medium;

import java.util.Arrays;

public class M462MinimumMovesEqual2 {

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        int midEl = nums[nums.length / 2], mid = nums.length / 2;
        int count = 0;

        while (l < mid) {
            if (nums[l] < midEl) {
                count += midEl - nums[l];
            }
            l++;
        }
        while (r > mid) {
            if (nums[r] > midEl) {
                count += nums[r] - midEl;
            }
            r--;
        }
        return count;
    }

    public int minMoves2_2(int[] nums) {
        Arrays.sort(nums);
        int mid = nums[nums.length / 2], count = 0;

        for (int i : nums) {
            count += Math.abs(mid - i);
        }
        return count;
    }

    public int minMoves2_3(int[] nums) {
        int l = 0, r = nums.length - 1, sum = 0;
        Arrays.sort(nums);
        while (l < r) {
            sum += nums[r] - nums[l];
            l++;
            r--;
        }
        return sum;
    }
}
