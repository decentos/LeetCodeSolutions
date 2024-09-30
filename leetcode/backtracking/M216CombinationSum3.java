package backtracking;

import java.util.ArrayList;
import java.util.List;

public class M216CombinationSum3 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtrack(combinations, new ArrayList<>(), 0, 1, k, n);
        return combinations;
    }

    private void backtrack(List<List<Integer>> combinations, List<Integer> curr, int sum, int index, int k, int n) {
        if (curr.size() == k) {
            if (sum == n) {
                combinations.add(new ArrayList<>(curr));
            }
            return;
        }

        for (int i = index; i <= 9; i++) {
            curr.add(i);
            backtrack(combinations, curr, sum + i, i + 1, k, n);
            curr.removeLast();
        }
    }
}
