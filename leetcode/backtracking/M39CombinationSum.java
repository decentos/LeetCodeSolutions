package backtracking;

import java.util.ArrayList;
import java.util.List;

public class M39CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        generate(ans, new ArrayList<>(), candidates, target, 0);
        return ans;
    }

    private void generate(List<List<Integer>> ans, List<Integer> curr, int[] candidates, int target, int index) {
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if (target < 0) return;

        for (int i = index; i < candidates.length; i++) {
            curr.add(candidates[i]);
            generate(ans, curr, candidates, target - candidates[i], i);
            curr.remove(curr.size() - 1);
        }
    }
}
