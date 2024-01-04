package medium;

import java.util.HashMap;
import java.util.Map;

public class M2870MinOperationsToArrayEmpty {

    public int minOperations(int[] nums) {
        int steps = 0;
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.merge(num, 1, Integer::sum);
        }

        for (int val : counter.values()) {
            if (val == 1) {
                return -1;
            }

            steps += val / 3;
            if (val % 3 != 0) {
                steps++;
            }
        }
        return steps;
    }
}
