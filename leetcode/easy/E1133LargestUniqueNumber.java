package easy;

import java.util.HashMap;
import java.util.Map;

public class E1133LargestUniqueNumber {

    public int largestUniqueNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.merge(num, 1, Integer::sum);

        int max = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1 && entry.getKey() > max) {
                max = entry.getKey();
            }
        }
        return max;
    }
}
