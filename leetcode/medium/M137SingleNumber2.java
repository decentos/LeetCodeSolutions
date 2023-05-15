package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class M137SingleNumber2 {

    public int singleNumber(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        Set<Integer> dups = new HashSet<>();

        for (int num : nums) {
            if (!dups.contains(num)) {
                dups.add(num);
                unique.add(num);
            } else {
                unique.remove(num);
            }
        }

        return unique.iterator().next();
    }

    public int singleNumber2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.merge(num, 1, Integer::sum);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) return entry.getKey();
        }
        return -1;
    }
}
