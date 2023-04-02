package w339;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M2610ConvertArrayInto2D {

    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.merge(num, 1, Integer::sum);
        while (true) {
            List<Integer> curr = new ArrayList<>();
            int index = ans.size() + 1;
            map.forEach((k,v) -> {
                if (v >= index) curr.add(k);
            });
            if (curr.isEmpty()) break;
            ans.add(curr);
        }
        return ans;
    }
}
