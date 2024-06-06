package greedy;

import java.util.TreeMap;

public class M1296DivideArrayConsecutive {

    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) {
            return false;
        }

        TreeMap<Integer, Integer> counter = new TreeMap<>();

        for (int num : nums) {
            counter.merge(num, 1, Integer::sum);
        }

        while (!counter.isEmpty()) {
            int lowest = counter.firstKey();
            if (counter.get(lowest) == 1) {
                counter.remove(lowest);
            } else {
                counter.merge(lowest, -1, Integer::sum);
            }

            for (int next = 1; next < k; next++) {
                if (!counter.containsKey(lowest + next)) {
                    return false;
                } else if (counter.get(lowest + next) == 1) {
                    counter.remove(lowest + next);
                } else {
                    counter.merge(lowest + next, -1, Integer::sum);
                }
            }
        }
        return true;
    }
}
