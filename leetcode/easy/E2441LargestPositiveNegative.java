package easy;

import java.util.HashSet;
import java.util.Set;

public class E2441LargestPositiveNegative {

    public int findMaxK(int[] nums) {
        int max = -1;
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            int abs = Math.abs(num);
            if (abs > max && seen.contains(-num)) {
                max = abs;
            }
            seen.add(num);
        }
        return max;
    }
}
