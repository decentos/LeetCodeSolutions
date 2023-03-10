package backtracking;

import java.util.ArrayList;
import java.util.List;

public class M77Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        fill(ans, new ArrayList<>(), 1, n, k);
        return ans;
    }

    private void fill(List<List<Integer>> ans, List<Integer> list, int curr, int n, int k) {
        if (list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = curr; i <= n; i++) {
            list.add(i);
            fill(ans, list, i + 1, n, k);
            list.remove(list.size() - 1);
        }
    }
}
