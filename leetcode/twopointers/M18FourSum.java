package twopointers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class M18FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < n - 3; i++) {
            int first = nums[i];
            if (i > 0 && nums[i - 1] == first) continue;

            for (int j = i + 1; j < n - 2; j++) {
                sum(ans, nums, first, j, target - first);
            }
        }
        return ans.stream().toList();
    }

    private void sum(Set<List<Integer>> ans, int[] nums, int first, int index, int target) {
        int curr = nums[index], left = index + 1, right = nums.length - 1;

        while (left < right) {
            long sum = (long) curr + (long) nums[left] + (long) nums[right];

            if (sum == target) {
                ans.add(List.of(first, curr, nums[left], nums[right]));
                left++;
                right--;

                while (left < right && nums[left - 1] == nums[left]) left++;
                while (left < right && nums[right + 1] == nums[right]) right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }
}
