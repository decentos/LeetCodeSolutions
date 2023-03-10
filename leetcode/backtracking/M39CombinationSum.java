package backtracking;

import java.util.ArrayList;
import java.util.List;

public class M39CombinationSum {
    private final List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        fill(candidates, 0, target, new ArrayList<>());
        return result;
    }

    private void fill(int[] candidates, int start, int remain, List<Integer> comb) {
        if (remain == 0) {
            result.add(new ArrayList<>(comb));
            return;
        } else if (remain < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            int curr = candidates[i];
            comb.add(curr);
            fill(candidates, i, remain - curr, comb);
            comb.remove(comb.size() - 1);
        }
    }
}
