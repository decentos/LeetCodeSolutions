package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class M15ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            sum(ans, nums, i);
        }
        return ans;
    }

    private void sum(List<List<Integer>> ans, int[] nums, int index) {
        int curr = nums[index], left = index + 1, right = nums.length - 1;

        while (left < right) {
            int sum = curr + nums[left] + nums[right];

            if (sum == 0) {
                ans.add(List.of(curr, nums[left], nums[right]));
                left++;
                right--;

                while (left < right && nums[left - 1] == nums[left]) left++;
                while (left < right && nums[right + 1] == nums[right]) right--;
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> ans = new HashSet<>();
        Set<Integer> seen = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int curr = nums[i];
            if (seen.contains(curr)) continue;
            seen.add(curr);

            for (int j = i + 1; j < n; j++) {
                int next = nums[j];
                int opposite = -curr - next;

                if (map.containsKey(opposite) && map.get(opposite) == i) {
                    int min = Math.min(curr, Math.min(next, opposite));
                    int max = Math.max(curr, Math.max(next, opposite));
                    int mid = curr + next + opposite - min - max;
                    ans.add(List.of(min, mid, max));
                }
                map.put(next, i);
            }
        }
        return ans.stream().toList();
    }
}
