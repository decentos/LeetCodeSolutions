package backtracking;

import java.util.ArrayList;
import java.util.List;

public class M78Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        backtrack(subsets, new ArrayList<>(), nums, 0);
        return subsets;
    }

    private void backtrack(List<List<Integer>> subsets, List<Integer> subset, int[] nums, int index) {
        subsets.add(new ArrayList<>(subset));

        for (int i = index; i < nums.length; i++) {
            subset.add(nums[i]);
            backtrack(subsets, subset, nums, i + 1);
            subset.removeLast();
        }
    }
}
