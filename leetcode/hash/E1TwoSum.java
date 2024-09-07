package hash;

import java.util.HashMap;
import java.util.Map;

public class E1TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int rest = target - current;
            Integer indexOfRest = map.get(rest);
            if (indexOfRest != null) {
                return new int[]{indexOfRest, i};
            }
            map.put(current, i);
        }
        return new int[]{};
    }
}
