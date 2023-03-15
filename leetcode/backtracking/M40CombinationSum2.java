package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M40CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
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
            if (i != index && candidates[i] == candidates[i - 1]) continue;

            curr.add(candidates[i]);
            generate(ans, curr, candidates, target - candidates[i], i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
