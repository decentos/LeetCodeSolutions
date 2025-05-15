package booking;

import java.util.ArrayList;
import java.util.List;

public class M46Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        backtrack(permutations, new ArrayList<>(), new boolean[nums.length], nums);
        return permutations;
    }

    private void backtrack(List<List<Integer>> permutations, List<Integer> curr, boolean[] used, int[] nums) {
        if (curr.size() == nums.length) {
            permutations.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            curr.add(nums[i]);
            used[i] = true;
            backtrack(permutations, curr, used, nums);
            curr.removeLast();
            used[i] = false;
        }
    }
}
