package backtracking;

import java.util.ArrayList;
import java.util.List;

public class M78Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        generate(ans, new ArrayList<>(), nums, 0);
        return ans;
    }

    private void generate(List<List<Integer>> ans, List<Integer> curr, int[] nums, int index) {
        ans.add(new ArrayList<>(curr));
        for (int i = index; i < nums.length; i++) {
            curr.add(nums[i]);
            generate(ans, curr, nums, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
