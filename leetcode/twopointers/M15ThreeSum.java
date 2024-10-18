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
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    ans.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return ans;
    }

// ===============================================================================

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
