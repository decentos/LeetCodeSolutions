package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M47Permutations2 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        fill(ans, new ArrayList<>(), nums, new boolean[nums.length]);
        return ans;
    }

    private void fill(List<List<Integer>> ans, List<Integer> curr, int[] nums, boolean[] seen) {
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (seen[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && seen[i - 1]) continue;
            curr.add(nums[i]);
            seen[i] = true;
            fill(ans, curr, nums, seen);
            seen[i] = false;
            curr.remove(curr.size() - 1);
        }
    }
}
