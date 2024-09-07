package hash;

import java.util.HashMap;
import java.util.Map;

public class E219ContainsDuplicate2 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int element = nums[i];
            if (map.containsKey(element)) {
                int prevIndex = map.get(element);
                if (i - prevIndex <= k) return true;
            }
            map.put(element, i);
        }
        return false;
    }
}
