package greedy;

import java.util.List;

public class M624MaxDistanceArrays {

    public int maxDistance(List<List<Integer>> arrays) {
        List<Integer> first = arrays.get(0);
        int min = first.get(0);
        int max = first.get(first.size() - 1);
        int ans = 0;

        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> curr = arrays.get(i);
            ans = Math.max(ans, max - curr.get(0));
            ans = Math.max(ans, curr.get(curr.size() - 1) - min);
            min = Math.min(min, curr.get(0));
            max = Math.max(max, curr.get(curr.size() - 1));
        }
        return ans;
    }
}
