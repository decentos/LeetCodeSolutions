package dp;

import java.util.HashMap;
import java.util.Map;

public class H446ArithmeticSlices2 {

    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int count = 0;
        Map<Integer, Integer>[] seq = new HashMap[n];

        for (int i = 0; i < n; i++) {
            seq[i] = new HashMap<>();

            for (int j = 0; j < i; j++) {
                long delta = (long) nums[i] - nums[j];
                if (delta > Integer.MAX_VALUE || delta < Integer.MIN_VALUE) {
                    continue;
                }
                int diff = (int) delta;
                int curr = seq[j].getOrDefault(diff, 0);
                int origin = seq[i].getOrDefault(diff, 0);
                seq[i].put(diff, curr + origin + 1);
                count += curr;
            }
        }
        return count;
    }
}
