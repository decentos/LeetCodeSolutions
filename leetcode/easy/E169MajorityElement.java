package easy;

import java.util.HashMap;
import java.util.Map;

public class E169MajorityElement {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) map.merge(i, 1, Integer::sum);
        return map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
    }

    // Boyer-Moore Voting Algorithm
    public int majorityElement2(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int i: nums) {
            if (count == 0) candidate = i;
            if (candidate == i) count++;
            else count--;
        }
        return candidate;
    }
}
