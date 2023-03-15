package backtracking;

import java.util.ArrayList;
import java.util.List;

public class M216CombinationSum3 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        generate(ans, new ArrayList<>(), k, n, 1);
        return ans;
    }

    private void generate(List<List<Integer>> ans, List<Integer> curr, int size, int target, int index) {
        if (target == 0 && curr.size() == size) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if (target < 0 || curr.size() == size) return;

        for (int i = index; i <= 9; i++) {
            curr.add(i);
            generate(ans, curr, size, target - i, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
