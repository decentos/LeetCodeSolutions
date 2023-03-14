package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M90Subsets2 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        generate(ans, new ArrayList<>(), nums, 0);
        return ans;
    }

    private void generate(List<List<Integer>> ans, List<Integer> curr, int[] nums, int index) {
        ans.add(new ArrayList<>(curr));
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) continue;
            curr.add(nums[i]);
            generate(ans, curr, nums, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
