package twopointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class M1679NumberSumPairs {

    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int count = 0;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == k) {
                count++;
                left++;
                right--;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }
        return count;
    }

// ===============================================================================

    public int maxOperations2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            int balance = k - curr;

            if (map.getOrDefault(balance, 0) > 0) {
                count++;
                map.merge(balance, -1, Integer::sum);
            } else {
                map.merge(curr, 1, Integer::sum);
            }
        }
        return count;
    }
}
